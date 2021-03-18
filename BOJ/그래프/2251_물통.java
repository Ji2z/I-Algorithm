import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 19.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2251
 * @mem 11752kb
 * @time 80ms
 * @caution S1
 */

public class 2251_물통 {
	
	static int A, B, C;
	static List<Integer> liter;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		liter = new ArrayList<>();
		visited = new boolean[201][201];
		water(0, 0, C);
		
		Collections.sort(liter);
		for (int i = 0; i < liter.size(); i++) {
			output.append(liter.get(i)).append(" ");
		}
		
		System.out.println(output);
	}

	static void water(int a, int b, int c) { 
		if(visited[a][b])
			return;
		
		if(a == 0) {
			if(!liter.contains(c))
				liter.add(c);
		}
		
		visited[a][b] = true;
		
		// C->A
		if(c != 0 && a != A) {
			if(a+c > A) 
				water(A, b, c-(A-a));
			else 
				water(a+c, b, 0);		
		}
		
		// C->B
		if(c != 0 && b != B) {
			if(b+c > B)
				water(a, B, c-(B-b));
			else
				water(a, b+c, 0);
		}
		
		// B->A
		if(b != 0 && a != A) {
			if(a+b > A)
				water(A, b-(A-a), c);
			else
				water(a+b, 0, c);
		}
		
		// B->C
		if(b != 0 && c != C) {
			if(c+b > C)
				water(a, b-(C-c), C);
			else
				water(a, 0, c+b);			
		}
		
		// A->C
		if(a != 0 && c != C) {
			if(c+a > C)
				water(a-(C-c), b, C);
			else 
				water(0, b, c+a);
		}
		
		// A->B
		if(a != 0 && b != B) {
			if(b+a > B)
				water(a-(B-b), B, c);
			else 
				water(0, b+a, c);
		}
	}
}