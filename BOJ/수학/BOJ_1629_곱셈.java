import java.io.*;
import java.util.*;

/**
* @since 2021. 7. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/1629
* @mem 11476kb
* @time 84ms
* @caution S1 분할정복, 자료형 조심
*/

public class BOJ_1629_곱셈 {

	static int A, B, C;
	static int answer;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
        
		System.out.println(pow(A%C, B));
	}

	static long pow(int a, int n) {
		
		if(n == 1) {
			return a%C;
		}
		
		long answer = pow(a, n/2)%C;
		answer = answer*answer%C;
		
		return n%2==0?answer:answer*A%C;
	}
}
