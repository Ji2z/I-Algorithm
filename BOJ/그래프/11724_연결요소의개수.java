import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 17.
 * @author Jin
 * @see https://www.acmicpc.net/problem/11724
 * @mem 144872kb
 * @time 608ms
 * @caution S2
 */

public class 11724_연결요소의개수 {

	static int N, M;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			list[from].add(to);
			list[to].add(from);
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		

		System.out.println(answer);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		
		for (int i : list[start]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
}