import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 22.
* @author Jin
* @see https://www.acmicpc.net/problem/15787
* @mem 47328kb
* @time 404ms
* @caution S2 비트마스킹
*/

public class BOJ_15787_기차가어둠을헤치고 {

	static int N, M;
	static boolean[][] train;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		train = new boolean[N][20];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken()) - 1;

			if (n == 1) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				train[t][x] = true;
			} else if (n == 2) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				train[t][x] = false;
			} else if (n == 3) {
				for (int k = 18; k >= 0; k--) {
					train[t][k + 1] = train[t][k];
				}
				train[t][0] = false;
			} else {
				for (int k = 0; k < 19; k++) {
					train[t][k] = train[t][k + 1];
				}
				train[t][19] = false;
			}
		}
		
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int num = 0;
			for (int j = 0; j < 20; j++) {
				if(train[i][j]) {
					num += (1<<j);
				}
			}
			set.add(num);
		}

		System.out.println(set.size());

	}

}
