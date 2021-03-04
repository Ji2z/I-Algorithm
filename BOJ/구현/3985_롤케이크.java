import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/3985
* @mem 11940kb
* @time 92ms
* @caution
*/

public class 롤_케이크_3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] cake = new int[L+1];
		int[] eat = new int[N+1];
		
		int max = 0; // 가장 많이 받길 원하는 개수
		int maxWant = 0; // 가장 많이 받길 원한 사람
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(max<end-start) {
				max = end-start;
				maxWant = i;
			}
			for (int j = start; j <= end; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					eat[i]++;
				}
			}
		}
		
		output.append(maxWant).append("\n");
		int maxEat = 0;
		int maxEatPerson = 0;
		for (int i = 1; i < eat.length; i++) {
			if(maxEat < eat[i]) {
				maxEat = eat[i];
				maxEatPerson = i;
			}
		}
		output.append(maxEatPerson).append("\n");
		System.out.println(output);
	}	
}
