import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 4. 10.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1806
 * @mem 22856kb
 * @time 228ms
 * @caution G4 투포인터
 */

public class 1806_부분합 {

	static int N, S;
	static int[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		number = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int answer = Integer.MAX_VALUE;
		int sum = 0;
		while(start<N) {
			if(sum>=S) {
				sum -= number[start++];
				answer = Math.min(answer, end-start+1);
			}else if (end==N) sum -= number[start++];
			else sum += number[end++];
		}
		
		
		System.out.println(answer==Integer.MAX_VALUE?0:answer);
	}

}