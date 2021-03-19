import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 19.
 * @author Jin
 * @see https://www.acmicpc.net/problem/9466
 * @mem 307320kb
 * @time 1216ms
 * @caution G4
 */

public class 9466_텀프로젝트 {

	static int T, N;
	static boolean[] visited;
	static int[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			list = new int[N];

			visited = new boolean[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken()) - 1;
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					cnt += dfs(i, i, new ArrayList<>());
				}
			}

			output.append(N - cnt).append("\n");
		}
		System.out.println(output);
	}

	static int dfs(int curr, int start, List<Integer> cnt) {
		visited[curr] = true;

		cnt.add(curr);
		int size = 0;
		int x = list[curr];
		if (curr == x)
			return 1;
		if (!visited[x]) {
			size = dfs(x, start, cnt);
		}else {
			for (int i = 0; i < cnt.size(); i++) {
				if(cnt.get(i)==x) {
					size = cnt.size()-i;
				}
			}
		}

		return size;
	}
}