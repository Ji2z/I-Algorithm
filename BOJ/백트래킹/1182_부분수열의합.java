import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 12.
* @author Jin
* @see https://www.acmicpc.net/problem/1182
* @mem 11844kb
* @time 92ms
* @caution S2
*/

public class 1182_부분수열의합 {

	static int N, S;
	static List<Integer> number;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		number = new ArrayList<>();
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			number.add(n);
		}
				
		plus(1, 0, false);
		plus(1, number.get(0), true);
		
		System.out.println(answer);
	}

	static void plus(int idx, int sum, boolean add) {
		if(add && sum == S) answer++;
		
		if(idx == N) return;
		plus(idx+1, number.get(idx)+sum, true);
		plus(idx+1, sum, false);
	}

}

