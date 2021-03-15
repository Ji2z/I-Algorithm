import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 15.
 * @author Jin
 * @see https://www.acmicpc.net/problem/17281
 * @mem 174700kb
 * @time 580ms
 * @caution G4
 */

public class 17281_⚾ {

	static int[][] list;
	static int maxScore = Integer.MIN_VALUE;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		list = new int[N][9];

		// 이닝 정보 받아오기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permu(9, new int[9], new boolean[9]);

		System.out.println(maxScore);
	}

	static void permu(int toChoose, int[] choosed, boolean[] visited) {
		if (toChoose == 0) {
			int score = calcScore(choosed);
			maxScore = Math.max(score, maxScore);
			return;
		}

		if (9 - toChoose == 3) {
			visited[0] = true;
			choosed[3] = 0;
			toChoose--;
		}

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[9 - toChoose] = i;
				permu(toChoose - 1, choosed, visited);
				visited[i] = false;
			}
		}
	}

	static int calcScore(int[] choosed) {
		int score = 0;
		int idx = 0;
		for (int n = 0; n < N; n++) {
			int out = 0;
			int[] ru = new int[9];
			Queue<Integer> juja = new ArrayDeque<>();
			while (out != 3) {
				int plus = list[n][choosed[idx]];
				if (plus == 0) {// 아웃이라면
					out++;
				}
				int size = juja.size();
				for (int i = 0; i < size; i++) {
					int temp = juja.poll();
					temp += plus;
					if (temp < 4) { // 홈으로 아직 안들어옴
						juja.offer(temp);
					} else
						score++;
				}
				if(plus != 0)
					juja.offer(plus);
				idx++;
				if (idx >= 9)
					idx = 0;
			} // while
		} // for N
		return score;
	}
}