import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/10989
 * @mem 480088kb
 * @time 1640ms
 * @caution S5, list의 sort로 풀면 메모리초과가 난다.
 */

public class 10989_수정렬하기3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num]++;
			max = Math.max(max, num);
		}	

		for (int i = 1; i <= max; i++) {
			for (int j = 0; j < arr[i]; j++) {
				output.append(i).append("\n");
			}	
		}
		
		System.out.println(output);
	}
}