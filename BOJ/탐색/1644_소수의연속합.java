import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021. 4. 7.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1644
 * @mem 24680kb
 * @time 168ms
 * @caution G3 에라토스테네스의 체 + 투포인터
 */

public class 1644_소수의연속합 {

	static int N;
	static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder("");
		//StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		make_prime(4000000);
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i < prime.length; i++) {
			if(!prime[i])
				list.add(i);
		}

		N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		int sum = 0;
		int start = 0;
		int end = 0;
		int size = list.size();
		while(start < size) {
			if(sum > N || end == size) sum -= list.get(start++);
			else sum += list.get(end++);
			if(sum==N) answer++;
		}
		
		System.out.println(answer);
	}

	public static void make_prime(int N) {
		prime = new boolean[N + 1];
		
		if (N < 2) 
			return;

		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (prime[i] == true) 
				continue;	
			for (int j = i * 2; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}
	}

}