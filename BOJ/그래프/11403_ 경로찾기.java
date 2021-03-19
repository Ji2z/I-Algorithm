import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 19.
 * @author Jin
 * @see https://www.acmicpc.net/problem/11403
 * @mem 13240kb
 * @time 136ms
 * @caution S1
 */

public class 11403_ 경로찾기 {

	static int N;
	static boolean[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				char c = st.nextToken().charAt(0);
				if (c == '1') {
					map[i][j] = true;
				}
			}
		}

		// 플로이드 워셜!!! => N^3
//		for (int k = 0; k < N; k++) { // 경유
//			for (int i = 0; i < N; i++) { // 시작점
//				for (int j = 0; j < N; j++) { // 도착점
//					if (i == j || !map[i][k] || !map[k][j]) // 경유지에서 경로 끊어짐
//						continue;
//					map[i][j] = true;
//					//if(map[i][j] > map[i][k] + map[k][j])
//					//	map[i][j] = map[i][k] + map[k][j];
//				}
//			}
//		}
		
		for (int k = 0; k < N; k++) { // 경유
			for (int i = 0; i < N; i++) { // 시작점
				for (int j = 0; j < N; j++) { // 도착점
					if (!map[i][k] || !map[k][j]) // 경유지에서 경로 끊어짐
						continue;
					map[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				output.append(map[i][j]?1:0).append(" ");
			}
			output.append("\n");
		}

		System.out.println(output);
	}

}