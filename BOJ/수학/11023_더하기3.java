import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 5.
* @author Jin
* @see https://www.acmicpc.net/problem/11023
* @mem 14804kb
* @time 128ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder();
		//StringTokenizer st = null;
		
		String[] num = br.readLine().split(" ");
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			sum += Integer.parseInt(num[i]);
		}
		System.out.println(sum);
	}
}