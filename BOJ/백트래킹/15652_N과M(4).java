import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/15652
* @mem 17492kb
* @time 164ms
* @caution
*/

public class Main {

	static StringBuilder output = new StringBuilder();
	static int n, r;
	static int[] arr;
	
	static void pick(int toChoose, int[] choosed, int startIdx) {
		if(toChoose == 0) {
			for(int a : choosed) {
				output.append(a).append(" ");
			}
			output.append("\n");
			return;
		}
		for (int i = startIdx; i < n; i++) {
				choosed[r-toChoose] = arr[i];
				pick(toChoose-1,choosed,i);

		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}

		pick(r, new int[r],0);
		System.out.println(output);
	}

}
