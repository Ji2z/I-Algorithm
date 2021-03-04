import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 3.
* @author Jin
* @see https://www.acmicpc.net/problem/1260
* @mem 17432kb
* @time 188ms
* @caution
*/

public class DFS와_BFS_1260 {
	
	static List<Integer>[] list;
	static boolean[] visited;
	static StringBuilder output;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V);
		output.append("\n");
		visited = new boolean[N+1];
		bfs(V);

		System.out.println(output);
	}
	
	static void dfs(int start) {
		if(visited[start])
			return;
		
		visited[start] = true;
		output.append(start).append(" ");
		for (int i : list[start]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			output.append(x).append(" ");
			for (int i : list[x]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}
}
