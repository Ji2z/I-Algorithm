import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/1194
* @mem 15064kb
* @time 104ms
* @caution G1 비트마스킹 + bfs
*/

public class BOJ_1194_달이차오른다,가자 {

	static int N, M;
	static char map[][];
	static boolean visited[][][];
	static int[][] deltas = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][128];
		
		int starti = 0, startj = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					starti = i;
					startj = j;
				}
			}
		}
		
		int answer = bfs(starti, startj);
		
		System.out.println(answer);
	}

	static int bfs(int si, int sj) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {si, sj, 0});
		visited[si][sj][0] = true;
		
		int cnt = -1;
		while(!queue.isEmpty()) {
			cnt++;
			int qsize = queue.size();
			for (int s = 0; s < qsize; s++) {
				int[] temp = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nr = temp[0] + deltas[d][0];
					int nc = temp[1] + deltas[d][1];
					
					if(isIn(nr, nc)&&map[nr][nc]!='#'&&!visited[nr][nc][temp[2]]) {
						char c = map[nr][nc];
						if(c=='.'||c=='0') {
							queue.add(new int[] {nr,nc,temp[2]});
							visited[nr][nc][temp[2]] = true;
						}else if(97<=(int)c&&(int)c<=102) { // 소문자 열쇠
							int key = temp[2]|(1<<((int)c-96));
							queue.add(new int[] {nr,nc,key});
							visited[nr][nc][key] = true;
						}else if(65<=(int)c&&(int)c<=70) { // 대문자 문
							int can = temp[2]&(1<<((int)c-64));
							if(can!=0) {
								queue.add(new int[] {nr,nc,temp[2]});
								visited[nr][nc][temp[2]] = true;
							}
						}else if(c=='1') {
							return cnt+1;
						}
					}
				}
			}
		}
		return -1;
	}
	
	static boolean isIn(int nr, int nc) {
		return 0<=nr&&nr<N&&0<=nc&&nc<M;
	}
}
