import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2.
 * @author
 * @see https://www.acmicpc.net/problem/15654
 * @mem 30388kb
 * @time 388ms
 * @caution
 */
public class Main {

	static int N;
	static int M;
	static int[] arr;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);		
		permutation(M, new int[M], new boolean[N]);
		System.out.println(output);
	}
	
	static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if(toChoose == 0) {
			for(int a: choosed) {
				output.append(a).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[M-toChoose] = arr[i];
				permutation(toChoose-1, choosed, visited);
				visited[i] = false;
				}
		}
	}

}