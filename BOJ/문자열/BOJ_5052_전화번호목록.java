import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 28.
* @author Jin
* @see https://www.acmicpc.net/problem/5052
* @mem 30668kb
* @time 600ms
* @caution G4, 트라이로도 풀 수 있다.
*/

public class BOJ_5052_전화번호목록 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		test : for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] numbers = new String[N];
			for (int n = 0; n < N; n++) {
				numbers[n] = br.readLine();
			}
			
			Arrays.sort(numbers);
			for (int i = 1; i < N; i++) {
				if(numbers[i].startsWith(numbers[i-1])) {
					output.append("NO\n");
					continue test;
				}
			}
			
			output.append("YES\n");
		}
		
		System.out.println(output);
	}

	

	
}
