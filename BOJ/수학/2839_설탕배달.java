package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 16.
* @author
* @see https://www.acmicpc.net/problem/2839
* @mem 14596kb
* @time 128ms
* @caution
*/

public class 설탕배달_2839 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		while(true) {
			if(N%5 == 0) {
				System.out.println(N/5+answer);
				break;
			}else if(N<=0) {
				System.out.println(-1);
				break;
			}
			N -= 3;
			answer++;
		}
	}
}
