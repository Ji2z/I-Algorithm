import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
* @since 2021. 3. 23.
* @author Jin
* @see https://www.acmicpc.net/problem/1463
* @mem 15508kb
* @time 96ms
* @caution S3
*/

public class 1463_1로만들기 {

	static int N;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		num = new int[N + 1];
		// 우리가 구할 값은 최소값 --> 최대값으로 초기화 해두자.
		Arrays.fill(num, Integer.MAX_VALUE);
		// 기저 조건에 해당하는 값: 1은 이미 1이기 때문에 추가적인 연산이 불필요하다.
		num[1] = 0;

		System.out.println(bottomUp(N));

	}

	static void find() {
		if (N >= 2)
			num[2] = 1;
		if (N >= 3)
			num[3] = 1;	

		for (int i = 4; i <= N; i++) {
			// 0. 현재 더해져있는 값 + (x-1)에 저장되어 있는 값
			num[i] = num[i - 1] + 1;

			// 1. 3의 배수면 x/3에 저장되어 있는 값+1
			if (i % 3 == 0)
				num[i] = Math.min(num[i], num[i / 3] + 1);

			// 2. 2의 배수면 x/2에 저장되어 있는 값+1
			if (i % 2 == 0)
				num[i] = Math.min(num[i], num[i / 2] + 1);

			//System.out.println(Arrays.toString(num));
		}
	}
	
	static int topDown(int n) {
		if(num[n] != Integer.MAX_VALUE) {
			return num[n];
		}
		
		// 아직 구해지지 ㅇ낳은 경우? 3가지 연산을 이용해서 최소 회수를 구해보자
		// 1. 1을 빼는 경우
		int temp = topDown(n-1);
		
		// 2. 3으로 나눠 떨어지는 경우
		if(n%3 == 0)
			temp = Math.min(temp, topDown(n/3));
		
		// 3. 2로 나눠 떨어지는 경우
		if(n%2 == 0)
			temp = Math.min(temp, topDown(n/2));
		
		return num[n] = temp + 1;
	}
	
	static int bottomUp(int n) {
		// n을 1로 만드는 방법의 회수를 저장하는 배열
		int[] memo = new int[n+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[1] = 0;
		
		for (int i = 2; i <= n; i++) {
			int temp = memo[i-1];
			if(i%3 == 0)
				temp = Math.min(temp, memo[i/3]);
			
			if(i%2 == 0)
				temp = Math.min(temp, memo[i/2]);
			memo[i] = temp + 1;
		}
		return memo[n];
	}
}
