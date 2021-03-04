import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/10250
* @mem 14720kb
* @time 136ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			if (N % H == 0) {
				output.append((H*100)+(N/H)).append("\n");
			} else {
				output.append(((N % H)*100)+(N/H)+1).append("\n");
			}
		}
		System.out.println(output);
	}

}
