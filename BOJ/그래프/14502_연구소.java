import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 26.
* @author Jin
* @see https://www.acmicpc.net/problem/14502
* @mem 126428kb
* @time 464ms
* @caution G5
*/

public class 14502_연구소 {

	static int N, M , max;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if(a==0)
					list.add(new int[] {i, j});
			}
		}
		
		comb(3, new int[3], 0);
		System.out.println(max);
		
	}
	
	static void comb(int toChoose, int[] choosed, int startIdx) {
		if(toChoose == 0) {
			for (int i = 0; i < choosed.length; i++) {
				int[] x = list.get(choosed[i]);
				map[x[0]][x[1]] = 1;
			}
			
			int sum = 0;
			//System.out.println(i+", "+j+" / "+i2+", "+j2+" / "+i3+", "+j3+" / ");
			visited = new boolean[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[r][c] == 0 && !visited[r][c]) {
						int temp = bfs(r, c);
						if(temp>0)
							sum+=temp;
					}
				}
			}
			//System.out.println(sum);
			max = Math.max(sum, max);
			
			for (int i = 0; i < choosed.length; i++) {
				int[] x = list.get(choosed[i]);
				map[x[0]][x[1]] = 0;
			}
			return;
		}
		
		for (int i = startIdx; i < list.size(); i++) {
			choosed[choosed.length-toChoose] = i;
			comb(toChoose-1, choosed, i+1);
		}
	}
	
	static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] {r,c});
		
		int cnt = 1;
		boolean flag = false;
		while(!queue.isEmpty()) {
			int[] x = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = x[0] + delta[i][0];
				int nc = x[1] + delta[i][1];
				
				if(0<=nr&&nr<N&&0<=nc&&nc<M&&map[nr][nc]==2) {
					flag = true;
				}
				
				if(0<=nr&&nr<N&&0<=nc&&nc<M&&map[nr][nc]==0&&!visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc});
					cnt++;
				}
			}
		}
		if(flag)
			return -1;
		return cnt;
	}
}
