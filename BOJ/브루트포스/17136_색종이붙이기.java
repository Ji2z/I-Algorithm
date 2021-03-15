import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 15.
 * @author Jin
 * @see https://www.acmicpc.net/problem/17136
 * @mem 20356kb
 * @time 196ms
 * @caution G2 그리디로 풀면 예외 발생. 브루트포스로 풀고 백트래킹을 해야한다.
 */

public class 17136_색종이붙이기 {

	static int[][] map;
	static int[] paper;
	static int cnt = 0;
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		map = new int[10][10];
		paper = new int[5];

		// 맵 정보 받아오기
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		attach(0, 0);
		if(minCnt==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minCnt);
	}

	static void attach(int r, int c) {
		if (c == 10) {
			attach(r + 1, 0);
			return;
		}

		if (r == 10) {
			minCnt = Math.min(cnt, minCnt);
			return;
		}

		if (map[r][c] == 0) {
			attach(r, c + 1);
			return;
		}

		for (int n = 5; n > 0; n--) {// 모든 색종이 해보기
			if (paper[n-1] == 5 || r + n > 10 || c + n > 10) // 색종이가 모자르거나, 범위를 벗어남
				continue;

			boolean flag = true;
			outer: for (int i = r; i < r + n; i++) {
				for (int j = c; j < c + n; j++) {
					if (map[i][j] == 0) {
						flag = false;
						break outer;
					}
				}
			} // outer

			if (!flag) // 색종이 못덮음. 작은걸로 시도
				continue;

			// 색종이 덮음 마킹
			for (int i = r; i < r + n; i++) {
				for (int j = c; j < c + n; j++) {
					map[i][j] = 0;
				}
			}

			paper[n - 1]++;
			cnt++;
			attach(r, c + n);

			// 색종이 덮었던거 복원
			for (int i = r; i < r + n; i++) {
				for (int j = c; j < c + n; j++) {
					map[i][j] = 1;
				}
			}

			paper[n - 1]--;
			cnt--;
			
		}
	}
}