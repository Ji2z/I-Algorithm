import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 22.
 * @author Jin
 * @see https://www.acmicpc.net/problem/13549
 * @mem 16156kb
 * @time 120ms
 * @caution G5 x+1보다 x-1이 먼저 와야 한다..
 */

public class 13549_숨바꼭질3 {

	static int N, K;
	static StringBuilder output;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new int[100001];

		bfs(N);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = 1;
		
		while (!queue.isEmpty()) {
				int x = queue.poll();
				
				if (x == K) {
					break;
				}
				
				int temp;				
				temp = x * 2;
				if (temp<= 100000 && visited[temp] == 0) {
					queue.offer(temp);
					visited[temp] = visited[x];
				}
				
				temp = x - 1;
				if (temp >= 0 && visited[temp] == 0) {
					queue.offer(temp);
					visited[temp] = visited[x] + 1;
				}
				
				temp = x + 1;
				if (temp <= 100000 && visited[temp] == 0) {
					queue.offer(temp);
					visited[temp] = visited[x] + 1;
				}
		}
		
		System.out.println(visited[K] - 1);
	}

}