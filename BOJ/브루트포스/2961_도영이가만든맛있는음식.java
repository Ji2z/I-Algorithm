package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 15.
* @author Jin
* @see https://www.acmicpc.net/problem/2961
* @mem 14372kb
* @time 128ms
* @caution
*/

public class 도영이가_만든_맛있는_음식_2961 {
	static int N, cnt = 0;
	static int[][] arr;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		// 배열 저장
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");		
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());	
		}

		powerSet(N, new boolean[N]);
		
		System.out.println(MIN);
	}
	
	static void powerSet(int toChoose, boolean[] choosed) {
		if(cnt == 1<<(N-1)) return;
		
		if(toChoose==0) {
			int sourT = 1, bitterT = 0;
			int sourF = 1, bitterF = 0;
			for (int i = 0; i < N; i++) {
				if(choosed[i]) {
					sourT *= arr[i][0];
					bitterT += arr[i][1];
				} else {
					sourF *= arr[i][0];
					bitterF += arr[i][1];
				}
			}
			int min = 0;
			if(sourF == 1 && bitterF == 0) min = Math.abs(sourT-bitterT);
			else min = Math.min(Math.abs(sourT-bitterT), Math.abs(sourF-bitterF));
			MIN = Math.min(min, MIN);
			cnt++;
			return;
		}
		
		choosed[choosed.length-toChoose] = true;
		powerSet(toChoose-1, choosed);
		choosed[choosed.length-toChoose] = false;
		powerSet(toChoose-1, choosed);
		
	}
}
