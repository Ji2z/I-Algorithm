import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 13.
* @author Jin
* @see https://www.acmicpc.net/problem/2143
* @mem 46768kb
* @time 836ms
* @caution G3 투포인터, 누적합
*/

public class 2143_두배열의합 {

	static int T, N, M;
	static int[] arrA, arrB;
	static long answer = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		arrA = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		arrB = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int n = arrA[i];
			A.add(n);
			for (int j = i+1; j < N; j++) {
				n += arrA[j];
				A.add(n);
			}
		}
		
		for (int i = 0; i < M; i++) {
			int n = arrB[i];
			B.add(n);
			for (int j = i+1; j < M; j++) {
				n += arrB[j];
				B.add(n);
			}
		}
		
		Collections.sort(A);
		Collections.sort(B);
		
		int sizeA = A.size();
		int sizeB = B.size();
		// A는 처음부터, B는 마지막부터 탐색
		int pointerA = 0;
		int pointerB = sizeB - 1;
		
		while(pointerA < sizeA && pointerB >= 0) {
			int cntA = 0;
			int cntB = 0;
			
			int sumA = A.get(pointerA); // A의 부분합
			int sumB = B.get(pointerB); // B의 부분합
			
			// 1. A + B = T 일때 answer에 반영
			if(sumA + sumB == T) {
				// sumA와 같은 숫자가 리스트 A에 여러개 있을 경우를 고려
				while(pointerA < sizeA && A.get(pointerA) == sumA) {
					pointerA++;
					cntA++;
				}
				while(pointerB >= 0 && B.get(pointerB) == sumB) {
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

