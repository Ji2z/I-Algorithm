import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
* @since 2021. 2. 26.
* @author Jin
* @see https://www.acmicpc.net/problem/2309
* @mem 11920kb
* @time 104ms
* @caution
*/

public class 일곱_난쟁이_2309 {

	static int[] tall;
	static StringBuilder output;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");
		
		tall = new int[9];
		
		for (int i = 0; i < 9; i++) {
			tall[i] = Integer.parseInt(br.readLine());
		}
		
		permutation(7, new int[7], new boolean[9], 0);
		
		System.out.println();
	}	
	
	static void permutation(int toChoose, int[] choosed, boolean[] visited, int sum) {
		if(sum>100) return;
		if(toChoose == 0) {
			if(sum == 100) {
				Arrays.sort(choosed);
				for (int i = 0; i < 7; i++) {
					output.append(choosed[i]).append("\n");
				}
				System.out.println(output);
				System.exit(0);
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[7-toChoose] = tall[i];
				permutation(toChoose-1, choosed, visited, sum+tall[i]);
				visited[i] = false;
			}
		}
	}
}
