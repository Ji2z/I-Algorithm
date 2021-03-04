package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 17.
* @author Jin
* @see https://www.acmicpc.net/problem/17135
* @mem 21216kb
* @time 272ms
* @caution
*/

public class 캐슬_디펜스_17135 {
	static int N, M, D, answer = Integer.MIN_VALUE;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// 맵 저장
		map = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		// 궁수의 위치는 0 ~ M-1의 인덱스를 가진다. => 0 ~ M-1에서 3가지를 뽑아 조합 만들기
		comb(3, new int[3], 0);

		System.out.println(answer);
	}

	// 궁수 3명 자리 뽑기
	static void comb(int toChoose, int[] choosed, int startIdx) {
		if (toChoose == 0) {
			int cnt = kill(choosed);
			answer = Math.max(answer, cnt);
			return;
		}

		for (int i = startIdx; i < M; i++) {
			choosed[choosed.length - toChoose] = i;
			comb(toChoose - 1, choosed, i + 1);
		}
	}

	// 제거 가능한 적의 최대 수 계산
	static int kill(int[] archerIdx) {
		// 살아있는 적 자리 표시
		int[][] testMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					testMap[i][j] = 0;
				else
					testMap[i][j] = 1;
			}
		}

		int cnt = 0;
		for (int row = N - 1; row >= 0; row--) {
			List<int[]> killR = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				int archer = archerIdx[i]; // 궁수 열 인덱스
				int near = Integer.MAX_VALUE;
				int nearI = -1;
				int nearJ = -1;
				boolean isNear = false;
				// 궁수 바꾸고 시작
				// check = 궁수가 가장 앞줄에서 쏠 수 있는 범위
				for (int check = archer - D + 1; check <= archer + D - 1; check++) {
					if (check >= 0 && check < M) { // 범위가 맵 안에 있을 때
						for (int d = 0; d <= D - Math.abs(archer - check) - 1; d++) {
							if (row - d >= 0 && testMap[row - d][check] == 1) {
								isNear = true;
								int distance = Math.abs(archer - check) + d + 1;
								if (near > distance) {
									nearI = row - d;
									nearJ = check;
									near = distance;
								}
							}
						}
					}
				} // 한 궁수 끝
				if (isNear == true) {
					int[] temp = new int[]{nearI, nearJ};
					killR.add(temp);
					isNear = false;
				}
			}// 궁수 3명 끝
			for (int i = 0; i < killR.size(); i++) {
				if(testMap[killR.get(i)[0]][killR.get(i)[1]] != 0) {
					testMap[killR.get(i)[0]][killR.get(i)[1]] = 0;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
