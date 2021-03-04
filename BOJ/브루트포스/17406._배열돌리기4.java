package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 10.
* @author
* @see https://www.acmicpc.net/problem/17406
* @mem 22052kb
* @time 368ms
* @caution
*/

public class 배열돌리기4_17406 {
	static int N, M;
	static int[][] arr;
	static int[][] testArr;
	static int[] order;
	static int[][] rotate;
	static int minScore = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken())+1;
		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		testArr = new int[N][M];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotate = new int[R][3];
		order = new int[R];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			rotate[i][0] = Integer.parseInt(st.nextToken());
			rotate[i][1] = Integer.parseInt(st.nextToken());
			rotate[i][2] = Integer.parseInt(st.nextToken());
			order[i] = i;
		}
		permutation(R, new int[R], new boolean[R]);
		
		System.out.println(minScore);
	}

	static int rotation(int[] orderIdx) {
		for (int o = 0; o < orderIdx.length; o++) {

			int rr = rotate[orderIdx[o]][0];
			int cc = rotate[orderIdx[o]][1];
			int ss = rotate[orderIdx[o]][2];

			int rs = rr - ss;
			int cs = cc - ss;
			int re = rr + ss;
			int ce = cc + ss;

			for (int j = 0; j < ss; j++) {
				int saved = testArr[rs][cs];
				for (int r = rs + 1; r <= re; r++) 
					testArr[r - 1][cs] = testArr[r][cs];
				for (int c = cs + 1; c <= ce; c++) 
					testArr[re][c - 1] = testArr[re][c];
				for (int r = re - 1; r >= rs; r--) 
					testArr[r + 1][ce] = testArr[r][ce];
				for (int c = ce - 1; c >= cs; c--) 
					testArr[rs][c + 1] = testArr[rs][c];
				testArr[rs][cs + 1] = saved;
				
				rs++;
				cs++;
				re--;
				ce--;
			}
		}
		
		int minSum = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			int sum = 0;
			for (int j = 1; j < M; j++) {
				sum += testArr[i][j];
			}
			minSum = Math.min(minSum, sum);
		}
		return minSum;
	}

	static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if (toChoose == 0) {
			int score = 0;
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < M; j++) {
					testArr[i][j] = arr[i][j];
				}
			}
			score = rotation(choosed);
			minScore = Math.min(minScore, score);
			return;
		}
		for (int i = 0; i < order.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[choosed.length - toChoose] = order[i];
				permutation(toChoose - 1, choosed, visited);
				visited[i] = false;
			}
		}
	}
}
