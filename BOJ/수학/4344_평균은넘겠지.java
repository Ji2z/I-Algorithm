import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 4.
* @author Jin
* @see https://www.acmicpc.net/problem/4344
* @mem 16068kb
* @time 196ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] score = new int[n];
			int sum = 0;
			for(int i=0; i<n; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}
			
			double avg = (double)sum/n;
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if(score[i]>avg) cnt += 1;
			}
			output.append(String.format("%.3f%%\n", (double)cnt/n*100));
		}
		System.out.println(output);
	}

}