import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/2458
* @mem 35724kb
* @time 508ms
* @caution G4 플로이드워셜
*/

public class BOJ_2458_키순서 {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			map[from][to] = 1;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (k == i)
					continue;
				for (int j = 0; j < N; j++) {
					if (i == j || j == k || map[i][k] == 0 || map[k][j] == 0)
						continue;
					map[i][j] = map[i][k] + map[k][j];
				}
			}
		}

		int cnt = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					cnt++;
				if (map[j][i] != 0)
					cnt++;
			}
			if (cnt == N - 1)
				answer++;
			cnt = 0;
		}

		System.out.println(answer);
	}
}
