import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 27.
 * @author Jin
 * @see https://www.acmicpc.net/problem/12851
 * @mem 39748kb
 * @time 184ms
 * @caution G5
 */

public class 12851_숨바꼭질2 {

	static int N, K;
	static StringBuilder output;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];

		bfs(N);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		int cnt = 0;
		int depth = -1;
		boolean flag = false;
		while (!queue.isEmpty() && !flag) {
			int size = queue.size();
			depth++;
			for (int s = 0; s < size; s++) {
				int x = queue.poll();
				visited[x] = true;
				
				if (x == K) {
					cnt++;
					flag = true;
					continue;
				}
				
				int temp;				
				temp = x * 2;
				if (temp<= 100000 && !visited[temp]) {
					queue.offer(temp);
				}
				
				temp = x - 1;
				if (temp >= 0 && !visited[temp]) {
					queue.offer(temp);
				}
				
				temp = x + 1;
				if (temp <= 100000 && !visited[temp]) {
					queue.offer(temp);
				}	
			}
		}
		
		System.out.println(depth);
		System.out.println(cnt);
	}

}