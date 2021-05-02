import java.io.*;
import java.util.*;

/**
* @since 2021. 5. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/11402
* @mem 11516kb
* @time 76ms
* @caution P5 이항계수
*/

public class BOJ_11402_이항계수4{

	static long N, K;
	static int M;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[M];
		arr[0] = 1;
		for (int i = 1; i < M; i++) {
			arr[i] = (arr[i - 1] * i) % M;
		}

		long answer = 1;
		while(N!=0 || K!=0) {
			long n = N%M;
			long r = K%M;
			if(n<r) answer = 0;
			if(answer == 0) break;
			answer = answer * (arr[(int)n] * (pow((arr[(int)(n-r)] * arr[(int)r]) % M, M-2))) % M;
			N /= M;
			K /= M;
		}
		
		System.out.println(answer);
	}
	
	static long pow(long num, long p) {
		if (p == 0)
			return 1;
		else if (num == 1)
			return num;

		long temp = pow(num, p / 2);
		if (p % 2 == 0)
			return (temp * temp) % M;
		else
			return ((temp * temp) % M * num) % M;

	}
	
}
