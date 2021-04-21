import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 22.
* @author Jin
* @see https://www.acmicpc.net/problem/17779
* @mem 31456kb
* @time 248ms
* @caution G4
*/

public class BOJ_17779_게리맨더링2 {

	static int N, answer, total;
	static int[][] map;
	static boolean[][] border;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		answer = Integer.MAX_VALUE;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}

		for (int d1i = 1; d1i <= N; d1i++) {
			for (int d2i = 1; d2i <= N; d2i++) {
				for (int xi = 0; xi < xi + d1i + d2i && xi + d1i + d2i < N; xi++) {
					for (int yi = 0; yi - d1i < yi && yi < yi + d2i && yi + d2i < N; yi++) {
						boolean can = makeBorder(xi, yi, d1i, d2i);
						if(can)
							divideGu(xi, yi, d1i, d2i);
					}
				}
			}
		}

		System.out.println(answer);
	}

	static boolean makeBorder(int x, int y, int d1, int d2) {
		border = new boolean[N][N];
		try {
			for (int i1 = 0; i1 <= d1; i1++) {
				for (int i2 = 0; i2 <= d2; i2++) {
					border[x + i1][y - i1] = true;
					border[x + i2][y + i2] = true;
					border[x + d1 + i2][y - d1 + i2] = true;
					border[x + d2 + i1][y + d2 - i1] = true;
				}
			}
			
			int temp = -1;
			for (int i = x+1; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(temp==-1 && border[i][j]) {
						temp = j;
					}else if(border[i][j]) {
						for (int j2 = temp; j2 < j; j2++) {
							border[i][j2] = true;
						}
						temp = -1;
						break;
					}
				}
			}
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

	static void divideGu(int x, int y, int d1, int d2) {
		int sum = 0;
		int[] gu = new int[5];
		int[][] deltas = { { 0, x + d1, 0, y+1 }, { 0, x + d2+1, y+1, N }, { x + d1, N, 0, y - d1 + d2 },{ x + d2+1, N, y - d1 + d2, N } };

		for (int del = 0; del < 4; del++) {
			for (int r = deltas[del][0]; r < deltas[del][1]; r++) {
				for (int c = deltas[del][2]; c < deltas[del][3]; c++) {
					if (border[r][c]) {
						if(del==0||del==2) break;
						else continue;
					}
					
					gu[del] = gu[del] + map[r][c];
					sum += map[r][c];
				}
			}
			if (gu[del] == 0)
				return;
		}

		gu[4] = total - sum;
		Arrays.sort(gu);
		answer = Math.min(answer, gu[4] - gu[0]);
	}

}
