import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 17.
 * @author Jin
 * @see https://www.acmicpc.net/problem/7562
 * @mem 65672kb
 * @time 288ms
 * @caution S2
 */

public class 7562_나이트의이동 {

	static int[][] delta = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int I = Integer.parseInt(br.readLine());
			visited = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine()," ");
			int curri = Integer.parseInt(st.nextToken());
			int currj = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			int targeti = Integer.parseInt(st.nextToken());
			int targetj = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<>();
			visited[curri][currj] = true;
			queue.offer(new int[] {curri, currj});
			
			if(curri==targeti&&currj==targetj) {
				output.append("0\n");
				continue;
			}
			
			int depth = 0;
			outer : while(!queue.isEmpty()) {
				int qsize = queue.size();
				depth++;
				for (int s = 0; s < qsize; s++) {
					int[] curr = queue.poll();
					
					int r = curr[0];
					int c = curr[1];
					for (int d = 0; d < 8; d++) {
						int nr = r + delta[d][0];
						int nc = c + delta[d][1];
						
						if(nr==targeti&&nc==targetj) {
							output.append(depth).append("\n");
							break outer;
						}
						if(0<=nr&&nr<I&&0<=nc&&nc<I&&!visited[nr][nc]) {
							visited[nr][nc] = true;
							queue.offer(new int[] {nr, nc});
						}
							
					}
				}
			}
			
		}
		
		System.out.println(output);
	}

}