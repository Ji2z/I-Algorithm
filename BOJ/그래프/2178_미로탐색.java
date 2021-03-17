import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 17.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2178
 * @mem 12244kb
 * @time 92ms
 * @caution S1
 */

public class 2178_미로탐색 {

	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] map;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if(s.charAt(j)=='1'){
					map[i][j] = true;
				}
			}
		}
		
		int answer = bfs(0, 0);
		
		System.out.println(answer);
	}

	static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		map[r][c] = false;
		int cnt = 0;
			
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			cnt++;
			for (int s = 0; s < qsize; s++) {
				int[] curr = queue.poll();
				int cur = curr[0];
				int cuc = curr[1];
				
				for (int i = 0; i < delta.length; i++) {
					int nr = cur + delta[i][0];
					int nc = cuc + delta[i][1];
					
					if(nr==N-1&&nc==M-1) {
						return cnt+1;
					}
					if(0<=nr&&nr<N&&0<=nc&&nc<M&&map[nr][nc]) {
						queue.offer(new int[] {nr,nc});
						map[nr][nc] = false;
					}
				}			
			}
		}		
		return cnt;
	}

}