import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 27.
 * @author Jin
 * @see https://www.acmicpc.net/problem/17087
 * @mem 27904kb
 * @time 276ms
 * @caution S1 - 최대공약수를 구하듯이 풀어야 시간이 6배 빠르다.
 */

public class 17087_숨바꼭질6 {

	static int N, S, min;
	static int[] people;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 동생 수
		S = Integer.parseInt(st.nextToken()); // 내 위치

		people = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int dist = Math.abs(Integer.parseInt(st.nextToken()) - S); // 나를 0으로 두고 얼만큼 떨어져있는지
			min = Math.min(dist, min);
			people[i] = dist;
		}

		// slove(); // 27884kb, 1472ms
		
		int answer = people[0];
		for (int i = 1; i < N; i++) {
			answer = gcd(answer, people[i]);
		}
		
		System.out.println(answer);
		
	}

	// 최대 공약수 구하는 법
	static int gcd(int a, int b) {
		if(b == 0)
			return a;
		else
			return gcd(b, a%b);
	}
	
	static void solve() {
		boolean flag = true;
		while(flag) {
			flag = false;
			for (int i = 0; i < N; i++) {
				if(people[i]%min!=0) {
					flag = true;
					min--;
					break;
				}
			}
		}
		
		System.out.println(min);
	}
}