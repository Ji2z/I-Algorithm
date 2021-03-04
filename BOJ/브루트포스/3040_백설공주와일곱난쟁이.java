package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 15.
* @author
* @see https://www.acmicpc.net/problem/3040
* @mem 14552kb
* @time 128ms
* @caution
*/

public class 백설_공주와_일곱_난쟁이_3040 {

	static int arr[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 모자 속 숫자 배열 저장
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		comb(7, new int[7], 0, 0);
	}
	
	static void comb(int toChoose, int[] choosed, int startIdx, int sum) {
		if(toChoose == 0) {
			if(sum == 100) {
				for (int i = 0; i < choosed.length; i++) {
					System.out.println(choosed[i]);
				}
				return;
			}
			return;
		}
		
		for (int i = startIdx; i < 9; i++) {
			choosed[choosed.length-toChoose] = arr[i];
			if(sum+arr[i]>100) continue;
			comb(toChoose-1, choosed, i+1, sum+arr[i]);
		}
	}
}
