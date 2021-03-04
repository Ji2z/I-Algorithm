package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 18.
* @author Jin
* @see https://www.acmicpc.net/problem/1987
* @mem 15720kb
* @time 860ms
* @caution
*/

public class 알파벳_1987 {
	static int R, C;
	static char[][] map;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[26];
		
		// 맵 저장
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		visited[(int)map[0][0]-65] = true;
		canGo(0, 0, 1);
		
		System.out.println(max);
	}
	
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}}; // 하, 우, 상, 좌
	static void canGo(int r, int c, int cnt) {
		
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[(int)map[nr][nc]-65]) {
				visited[(int)map[nr][nc]-65] = true;
				canGo(nr, nc, cnt+1);
				visited[(int)map[nr][nc]-65] = false;
			}
		}
		
		max = Integer.max(max, cnt);
	}
}
