import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @since 2021. 3. 17.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2667
 * @mem 11592kb
 * @time 80ms
 * @caution S1
 */

public class 2667_단지번호붙이기 {

	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if(s.charAt(j)=='1'){
					map[i][j] = true;
				}
			}
		}
		
		List<Integer> cntList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]){
					map[i][j] = false;
					int cnt = bfs(i, j);
					cntList.add(cnt);
				}
			}
		}
		
		Collections.sort(cntList);
		
		output.append(cntList.size()).append("\n");
		for (int i = 0; i < cntList.size(); i++) {
			output.append(cntList.get(i)).append("\n");
		}
		
		System.out.println(output);
	}

	static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cur = curr[0];
			int cuc = curr[1];
			
			for (int i = 0; i < delta.length; i++) {
				int nr = cur + delta[i][0];
				int nc = cuc + delta[i][1];
				
				if(0<=nr&&nr<N&&0<=nc&&nc<N&&map[nr][nc]) {
					queue.offer(new int[] {nr,nc});
					map[nr][nc] = false;
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}