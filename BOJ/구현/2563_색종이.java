package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 9.
* @author
* @see https://www.acmicpc.net/problem/2563
* @mem 14332kb
* @time 128ms
* @caution
*/

public class 색종이_2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		int answer = 100*T;
		boolean[][] map = new boolean[100][100];
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			x -= 1;
			for (int xi = 0; xi < 10; xi++) {
				for (int yi = 0; yi < 10; yi++) {
					if(map[100-y-yi][x+xi]==false) {
						map[100-y-yi][x+xi] = true;
					}else answer--;
				}
			}
		}
		System.out.println(answer);
	}
}
