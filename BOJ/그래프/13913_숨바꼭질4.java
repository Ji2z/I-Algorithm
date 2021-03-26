import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 27.
 * @author Jin
 * @see https://www.acmicpc.net/problem/13913
 * @mem 22992kb
 * @time 220ms
 * @caution G4
 */

public class 13913_숨바꼭질4 {

	static int N, K;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new int[100001];
		Arrays.fill(visited, -1);

		int cnt = bfs(N);
		int[] answer = new int[cnt+1];
		
		answer[0] = K;
		for (int i = 1; i <= cnt; i++) {
			answer[i] = visited[answer[i-1]];
		}
		
		StringBuilder output = new StringBuilder("");
		output.append(cnt).append("\n");
		for (int i = cnt; i >= 0; i--) {
			output.append(answer[i]).append(" ");
		}
		
		System.out.println(output);
	}

	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		int depth = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			for (int s = 0; s < size; s++) {
				int x = queue.poll();

				if (x == K) {
					return depth;
				}

				int temp;
				temp = x * 2;
				if (temp <= 100000 && visited[temp] == -1) {
					queue.offer(temp);
					visited[temp] = x;
				}

				temp = x - 1;
				if (temp >= 0 && visited[temp] == -1) {
					queue.offer(temp);
					visited[temp] = x;
				}

				temp = x + 1;
				if (temp <= 100000 && visited[temp] == -1) {
					queue.offer(temp);
					visited[temp] = x;
				}
			}
		}
		return -1;
	}

}