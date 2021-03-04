import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 3.
* @author Jin
* @see https://www.acmicpc.net/problem/3190
* @mem 13512kb
* @time 112ms
* @caution 뱀 몸통 체크를 잘 해주자...
*/

public class 뱀_3190 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N]; // 1은 사과, 2는 뱀
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		// 뱀 머리 위치
		int r = 0;
		int c = 0;
		map[r][c] = 2;
		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우, 하, 좌, 상
		// 현재 방향
		int direct = 0;
		// 몇 초
		int sec = 1;
		// 뱀 좌표
		Queue<int[]> snakeQ = new LinkedList<>();
		snakeQ.add(new int[] { 0, 0 });
		// break 여부
		boolean flag = false;
		snake: for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);

			for (; sec <= time; sec++) {
				if (direct == 0) { // 우
					r += direction[0][0];
					c += direction[0][1];

				} else if (direct == 1) { // 하
					r += direction[1][0];
					c += direction[1][1];

				} else if (direct == 2) { // 좌
					r += direction[2][0];
					c += direction[2][1];

				} else if (direct == 3) { // 상
					r += direction[3][0];
					c += direction[3][1];
				}

				// 맵에 있는지 확인
				if (r >= 0 && r < N && c >= 0 && c < N) {
					// 도착한 곳에서 사과 발견!!
					if (map[r][c] == 1) {
						map[r][c] = 2;
						snakeQ.offer(new int[] { r, c });
					} else if (map[r][c] == 2) { // 도착한 곳이 내 몸통
						flag = true;
						System.out.println(sec);
						System.exit(0);
						break snake;
					} else { // 도착한 곳이 빈 곳 => 이전 곳을 빈칸으로
						snakeQ.offer(new int[] { r, c });
						map[r][c] = 2;
						int[] blank = snakeQ.poll();
						map[blank[0]][blank[1]] = 0;
					}
				} else {
					flag = true;
					System.out.println(sec);
					System.exit(0);
					break snake;
				}

			} // time for

			// direct : 우, 하, 좌, 상
			if (d == 'L') { // 좌회전
				if (direct == 0) // 오른쪽 -> 위로
					direct = 3;
				else if (direct == 1) // 아래 -> 오른쪽
					direct = 0;
				else if (direct == 2) // 왼쪽 -> 아래
					direct = 1;
				else if (direct == 3) // 위로 -> 왼쪽
					direct = 2;
			} else { // 우회전
				if (direct == 0) // 오른쪽 -> 아래로
					direct = 1;
				else if (direct == 1) // 아래 -> 왼쪽
					direct = 2;
				else if (direct == 2) // 왼쪽 -> 위로
					direct = 3;
				else if (direct == 3) // 위로 -> 오른쪽
					direct = 0;
			}
		} // snake for

		if (!flag) {
			for (;; sec++) {
				if (direct == 0) { // 우
					r += direction[0][0];
					c += direction[0][1];

				} else if (direct == 1) { // 하
					r += direction[1][0];
					c += direction[1][1];

				} else if (direct == 2) { // 좌
					r += direction[2][0];
					c += direction[2][1];

				} else if (direct == 3) { // 상
					r += direction[3][0];
					c += direction[3][1];
				}

				// 맵에 있는지 확인
				if (r >= 0 && r < N && c >= 0 && c < N) {
					// 도착한 곳에서 사과 발견!!
					if (map[r][c] == 1) {
						map[r][c] = 2;
						snakeQ.offer(new int[] { r, c });
					} else if (map[r][c] == 2) { // 도착한 곳이 내 몸통
						break;
					} else { // 도착한 곳이 빈 곳 => 이전 곳을 빈칸으로
						snakeQ.offer(new int[] { r, c });
						int[] blank = snakeQ.poll();
						map[blank[0]][blank[1]] = 0;
					}
				} else {
					break;
				}
			}
		}

		System.out.println(sec);
	}
}
