import java.io.*;
import java.util.*;

/**
* @since 2021. 5. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2846
* @mem 11780kb
* @time 80ms
* @caution B2
*/

public class BOJ_2846_오르막길{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int check = start;
		int end = 0;
		int answer = 0;
		for (int i = 1; i < N; i++) {
			end = Integer.parseInt(st.nextToken());
			if(check<end) {
				check = end;
				answer = Math.max(end-start,answer);
			}else {
				start = end;
				check = start;
			}
		}
		
		System.out.println(answer);
	}
}
