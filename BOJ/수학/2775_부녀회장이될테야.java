import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 4.
* @author Jin
* @see https://www.acmicpc.net/problem/2775
* @mem 14564kb
* @time 464ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		// StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			output.append(many(k, n)).append("\n");
		}
		System.out.println(output);
	}

	static int many(int k, int n) {
		if (n == 0) {
			return 0;
		} else if(k == 0){
			return n;
		} else {
			return many(k,n-1)+many(k-1,n);
		}
	}
}