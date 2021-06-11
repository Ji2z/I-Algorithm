import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 11.
* @author Jin
* @see https://www.acmicpc.net/problem/7795
* @mem 40604kb
* @time 384ms
* @caution S3
*/

public class BOJ_7795_먹을것인가먹힐것인가 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[A];
			int[] brr = new int[B];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int a = 0; a < A; a++) 
				arr[a] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int b = 0; b < B; b++) 
				brr[b] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			Arrays.sort(brr);
			int idx = B-1;
			int answer = 0;
			for (int i = A-1; i >= 0; i--) {
				int a = arr[i];
				for (int j = idx; j >= 0; j--) {
					int b = brr[j];
					if(a>b) {
						idx = j;
						answer += (j+1);
						break;
					}
				}
			}
			output.append(answer).append("\n");
		}
		System.out.println(output);
	}
}
