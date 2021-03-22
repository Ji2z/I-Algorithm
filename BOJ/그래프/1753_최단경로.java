import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 22.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1753
 * @mem 108696kb
 * @time 628ms
 * @caution G5 다익스트라
 */

public class 1753_최단경로 {

	static int V, E, K;
	static LinkNode[] graph;
	static StringBuilder output;
	
	// PQ에서 관리하기 위해서 Comparable 하게 만들자.
	static class LinkNode implements Comparable<LinkNode>{
		int i, c;	// 번호와 비용
		LinkNode pre;	// 이전 노드 정보
		
		public LinkNode(int i, int c, LinkNode pre) {
			super();
			this.i = i;
			this.c = c;
			this.pre = pre;
		}

		@Override
		public String toString() {
			return "LinkNode [i=" + i + ", c=" + c + ", pre=" + pre + "]";
		}

		@Override
		public int compareTo(LinkNode o) {
			return Integer.compare(this.c, o.c);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken()) + 1; // 모든 정점은 1부터 시작
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		graph = new LinkNode[V];
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// 단방향 그래프
			graph[a] = new LinkNode(b, w, graph[a]);
		}
		
		// dijkstra(K);
		dijkstraPQ(K);
		
		System.out.println(output);
	}
	
	static void dijkstraPQ(int start) {
		// 상황판.
		boolean[] visited = new boolean[V];
		int[] dist = new int[V];
		int inf = 987654321;
		Arrays.fill(dist, inf);		
		PriorityQueue<LinkNode> pq = new PriorityQueue<>();
		
		// 출발지 선정
		dist[start] = 0;
		pq.add(new LinkNode(start, 0, null));
		
		while(!pq.isEmpty()) {
			// 하나를 뽑으면 그게 최소
			LinkNode head = pq.poll();
			if(visited[head.i])
				continue;
			// 방문 처리
			visited[head.i] = true;
			
			// 자식 탐색
			LinkNode child = graph[head.i];
			while(child != null) {
				if(!visited[child.i] && dist[child.i] > dist[head.i] + child.c) {
					dist[child.i] = dist[head.i] + child.c;
					// head를 넣어주면 손쉽게 경로를 역추적 할 수 있다.
					pq.add(new LinkNode(child.i, dist[child.i], head));
				}
				child = child.pre;
			}
		} // pq 동작 완료
		// System.out.println(Arrays.toString(dist));
		
		// 답 출력
		for (int i = 1; i < dist.length; i++) {
			int d = dist[i];
			if(d == inf)
				output.append("INF\n");
			else
				output.append(d).append("\n");
		}
	}

	static void dijkstra(int start) {
		// 잘 동작하고 있는지 점검할 상황판
		boolean[] visited = new boolean[V];
		int[] dist = new int[V]; // 누적 거리를 기록할 배열 --> 여기 등록된 값을 최대한 줄여보자.
		// 일단은 미지의 세계..
		int inf = 987654321; // Integer.MAX_VALUE를 하지 않는 이유는 오버 플로우 방지. inf+x 같은 코드가 나올 경우 대비
		Arrays.fill(dist, inf);
		
		// 탐색의 시작
		// 출발점의 누적 비용은 언제나 0
		dist[start] = 0;
		
		// 모든 정점의 개수만큼 탐색이 이뤄진다.
		for (int v = 0; v < V; v++) {
			// 최소 누적 비용 정점과 그때의 비용 초기화
			int minVer = 0, minCost = inf;
			for (int i = 1; i < V; i++) {
				// 아직 미방문이고 거기로 가는 누적 비용이 minCost보다 작다면..
				if(!visited[i] && dist[i] < minCost) {
					minVer = i;
					minCost = dist[i];
				}
			}
			
			// 탐색 지점이 결정되었다!! --> 방문 처리
			visited[minVer] = true;
			// 다음 자식을 찾아가보자.
			LinkNode child = graph[minVer];
			
			while(child != null) {
				// 자식 중 아직 미방문이고 거쳐서 갔더니 누적 비용이 오히려 더 싸진 지점.......,.,.
				if(!visited[child.i] && dist[child.i] > dist[minVer] + child.c) {
					dist[child.i] = dist[minVer] + child.c;
				}
				child = child.pre;
			}
		}// dijkstra 탐색
		//System.out.println(Arrays.toString(dist));
		
		// 답 출력
		for (int i = 1; i < dist.length; i++) {
			int d = dist[i];
			if(d == inf)
				output.append("INF\n");
			else
				output.append(d).append("\n");
		}
	}
}