import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 22.
* @author Jin
* @see https://www.acmicpc.net/problem/2467
* @mem 31648kb
* @time 284ms
* @caution G5 투 포인터
*/

public class BOJ_2467_용액 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = N-1;
		int a = 0;
		int b = N-1;
		int sum = 2000000000;
		
		while(start<end) {
			int temp = arr[start]+arr[end];
			if(Math.abs(temp) < Math.abs(sum)) {
				sum = temp;
				a = start;
				b = end;
			}
			if(temp < 0)
				start++;
			else
				end--;
			if(sum == 0)
				break;
		}

		output.append(arr[a]).append(" ").append(arr[b]);
		System.out.println(output);

	}

}
