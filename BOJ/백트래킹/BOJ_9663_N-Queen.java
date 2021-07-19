import java.io.*;
import java.util.*;

/**
* @since 2021. 7. 19.
* @author Jin
* @see https://www.acmicpc.net/problem/9663
* @mem 12408kb
* @time 6440ms
* @caution S5
*/

public class BOJ_9663_N-Queen {

	static int N;
	static int answer;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
		answer = 0;

		for (int i = 0; i < N; i++) {
			map = new int[N];
			map[0] = i;
			queen(1);
		}

		System.out.println(answer);

	}

	static void queen(int r) {
		if (r == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			boolean check = true;
			for (int j = 0; j < r; j++) {
				map[r] = i;
				if(map[j]==map[r]||Math.abs(j-r)==Math.abs(map[j]-map[r])) {
					check = false;
					break;
				}
			}
			
			if(check) {
				queen(r+1);
			}
		}
		
	}
}
