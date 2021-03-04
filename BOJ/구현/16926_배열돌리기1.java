package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 10.
* @author Jin
* @see https://www.acmicpc.net/problem/16926
* @mem 29980kb
* @time 856ms
* @caution
*/

public class 배열돌리기1_16926 {
static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};	
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int depth = Math.min(N, M)/2;
		
		String[][] arr = new String[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(" ");
		}
		
		for (int r = 0; r < R; r++) {
			for (int d = 0; d < depth; d++) {
				int x = d;
				int y = d;
				
				String value = arr[x][y];
				int direct = 0;
				
				while(direct<4) {
					int nx = x+deltas[direct][0];
					int ny = y+deltas[direct][1];
					if(nx>=d && nx<N-d && ny>=d && ny<M-d) {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					} else direct++;
				}
				arr[d+1][d] = value;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				output.append(arr[i][j]).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}
