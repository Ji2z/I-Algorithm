import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/2559
* @mem 25080kb
* @time 1136ms
* @caution
*/

public class 수열_2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int maxTemp = Integer.MIN_VALUE;
		int[] temp = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N-K; i++) {
			int sum = 0;
			for (int j = 0; j < K; j++) {
				sum += temp[i+j];
			}
			maxTemp = Integer.max(maxTemp, sum);			
		}
			
		System.out.println(maxTemp);
	}	
}
