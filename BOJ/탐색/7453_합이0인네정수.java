import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 14.
* @author Jin
* @see https://www.acmicpc.net/problem/7453
* @mem 152512kb
* @time 3684kb
* @caution G2 리스트로 하면 시간초과
*/

public class 7453_합이0인네정수 {
	static int T, N, M;
	static int[] arrA, arrB, arrC, arrD;
	static long answer = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		arrA = new int[N];
		arrB = new int[N];
		arrC = new int[N];
		arrD = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arrA[i] = Integer.parseInt(st.nextToken());
			arrB[i] = Integer.parseInt(st.nextToken());
			arrC[i] = Integer.parseInt(st.nextToken());
			arrD[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] A = new int[N*N];
		int[] B = new int[N*N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i*N+j] = arrA[i]+arrB[j];
				B[i*N+j] = arrC[i]+arrD[j];
			}
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sizeA = A.length;
		int sizeB = B.length;
		// A는 처음부터, B는 마지막부터 탐색
		int pointerA = 0;
		int pointerB = sizeB - 1;
		
		while(pointerA < sizeA && pointerB >= 0) {
			int cntA = 0;
			int cntB = 0;
			
			int sumA = A[pointerA]; // A의 부분합
			int sumB = B[pointerB]; // B의 부분합
			
			// 1. A + B = T 일때 answer에 반영
			if(sumA + sumB == 0) {
				// sumA와 같은 숫자가 리스트 A에 여러개 있을 경우를 고려
				while(pointerA < sizeA && A[pointerA] == sumA) {
					pointerA++;
					cntA++;
				}
				while(pointerB >= 0 && B[pointerB] == sumB) {
					pointerB--;
					cntB++;
				}
				
				answer += ((long)cntA * (long)cntB);
			}
			// 2. A + B < T 일때,  A를 더 큰 숫자로 변경
			else if(sumA + sumB < T) 
				pointerA++;
			// 3. A + B > T 일때, B를 더 작은 숫자로 변경
			else //if(sumA + sumB > T)
				pointerB--;
		}
		
		System.out.println(answer);
	}
}
