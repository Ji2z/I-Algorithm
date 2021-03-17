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
 * @see https://www.acmicpc.net/problem/7576
 * @mem 120096kb
 * @time 644ms
 * @caution S1
 */

public class 7576_토마토 {

	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] tomato;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		boolean all = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				tomato[i][j] = a;
				if(a==1) 
					queue.offer(new int[] {i,j});	
				if(a==0)
					all = false;
			}
		}
		
		if(all) {
			System.out.println(0);
			System.exit(0);
		}
		
		int days = -1;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			for (int s = 0; s < qsize; s++) {
				int[] curr = queue.poll();
				int cur = curr[0];
				int cuc = curr[1];
				
				for (int i = 0; i < delta.length; i++) {
					int nr = cur + delta[i][0];
					int nc = cuc + delta[i][1];
					
					if(0<=nr&&nr<N&&0<=nc&&nc<M&&tomato[nr][nc]==0) {
						queue.offer(new int[] {nr,nc});
						tomato[nr][nc] = 1;
					}
				}			
			}
			days++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
			
		System.out.println(days);
	}
}