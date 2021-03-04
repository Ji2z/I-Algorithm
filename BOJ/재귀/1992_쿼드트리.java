package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 17.
* @author Jin
* @see https://www.acmicpc.net/problem/1992
* @mem 14440kb
* @time 132ms
* @caution
*/

public class 쿼드트리_1992 {
	static int N;
	static char[][] map;
	static StringBuilder output;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");

		N = Integer.parseInt(br.readLine());

		// 맵 저장
		map = new char[N][N];
		for (int n = 0; n < N; n++) {
			map[n] = br.readLine().toCharArray();
		}
		divideFour(N, 0, 0);
		System.out.println(output);
	}

	static void divideFour(int size, int startI, int startJ) {
		
		myFor : for (int i = startI; i < startI+size; i++) {
			for (int j = startJ; j < startJ+size; j++) {
				if(map[startI][startJ] != map[i][j]) {
					output.append("(");
					divideFour(size/2, startI, startJ);
					divideFour(size/2, startI, startJ+size/2);
					divideFour(size/2, startI+size/2, startJ);
					divideFour(size/2, startI+size/2, startJ+size/2);
					output.append(")");
					break myFor;
				}
			}
			if(i+1==startI+size) {
				output.append(map[startI][startJ]);	
				return;
			}
		}// myFor
	}
}
