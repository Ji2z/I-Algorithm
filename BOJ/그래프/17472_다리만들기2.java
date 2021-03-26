import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 26.
 * @author Jin
 * @see https://www.acmicpc.net/problem/17472
 * @mem 11684kb
 * @time 84ms
 * @caution G2 / solve1로 풀었을때 bfs쪽때문에 시간이 3배 더 걸리는 것 같다.
 */

public class 17472_다리만들기2 {

	static int N, M, max;
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<int[]> list;
	static int[] repres;
	static boolean[][] visited;
	
	static int islandIdx = 2; // 0과 1은 지도에서 사용중!!
	static PriorityQueue<Edge> edges = new PriorityQueue<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료
		// solve1() => 18444kb / 232ms
		
		// 섬 구별 --> 정점 파악
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					dfs(i, j);
					islandIdx++;
				}
			}
		}
		// 맵 확인
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		// 각 섬별로 거리 찾아보기.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					// 간선 찾아가기
					makeEdge(i, j);
				}
			}
		}
		//System.out.println(edges);
		
		// MST 구하기
		kruskal();
	}
	
	static void kruskal() {
		make();
		
		int totalCost = 0;
		while(!edges.isEmpty()) {
			Edge head = edges.poll();
			if(union(head.a, head.b)) {
				totalCost += head.cost;
			}
		}
		//System.out.println(totalCost);
		// 각 섬의 연결 정보
		// 여기 인덱스 2부터 우리가 사용하는거니까 -1이 여러개 나오면 다 연결되지 않은 것. 한개만 나와야 한다.
		// System.out.println(Arrays.toString(repres)); 
		// 모든 점의 연결 확인..
		int repreCnt = 0;
		for (int i = 2; i < repres.length; i++) {
			if(repres[i] < 0)
				repreCnt++;
		}
		
		System.out.println(repreCnt>1?-1:totalCost);
	}
	
	static void makeEdge(int r, int c) {
		int baseIdx = map[r][c];
		for (int d = 0; d < delta.length; d++) {
			for (int l = 1; ; l++) {
				int nr = r + delta[d][0]*l;
				int nc = c + delta[d][1]*l;
				
				if(isIn(nr,nc)) {
					if(map[nr][nc] == 0) { // 바다
						continue;
					}else if(map[nr][nc] == baseIdx) { // 내륙
						break;
					}else { // 다른 땅
						if(l>2) {
							Edge e = new Edge(baseIdx, map[nr][nc], l-1);
							edges.offer(e);
						}
						break;
					}
				}else {// 영역을 벗어나버리면 더 이상 갈 필요가 없다.
					break;
				}
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int a, b, cost;

		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	static void dfs(int r, int c) {
		map[r][c] = islandIdx;
		
		for (int d = 0; d < delta.length; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			
			if(isIn(nr,nc)&&map[nr][nc]==1) {
				dfs(nr, nc);
			}
		}
	}
	
	
	
	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int[] x = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = x[0] + delta[i][0];
				int nc = x[1] + delta[i][1];

				if (isIn(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					queue.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
					union(nr * M + nc, r * M + c);
				}
			}
		}
	}

	static boolean isIn(int nr, int nc) {
		return (0 <= nr && nr < N && 0 <= nc && nc < M);
	}

	
	
	static void make() {
		//repres = new int[N * M];
		repres = new int[islandIdx];
		Arrays.fill(repres, -1);
	}

	static int find(int a) {
		if (repres[a] < 0) {
			return a;
		} else {
			return repres[a] = find(repres[a]);
		}
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		repres[a] += repres[b];
		repres[b] = a;
		return true;
	}
	
	static void solve1() {
		// 18444kb / 232ms
		make();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> {return Integer.compare(o1[2], o2[2]);}); // a, b, dist
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int dist = 0;
						int nr = i + delta[d][0];
						int nc = j + delta[d][1];

						while (isIn(nr, nc) && map[nr][nc] == 0) {
							nr += delta[d][0];
							nc += delta[d][1];
							dist++;
						}
						if (isIn(nr, nc) && map[nr][nc] == 1 ) {
							int a = find(i * M + j);
							int b = find(nr * M + nc);
							if(a!=b && dist>=2) {
								pq.offer(new int[] {a,b,dist});
							}
						}
					}
				}
			}
		}

		int answer = 0;
		while(!pq.isEmpty()) {
			int[] x = pq.poll();
			boolean result = union(x[0], x[1]);
			if(result) {
				answer += x[2];
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					int temp = find(i*M+j);
					if(!list.contains(temp))
						list.add(temp);
				}			
			}	
		}
		
		if(list.size()==1)
			System.out.println(answer);
		else
			System.out.println(-1);

	}

}
