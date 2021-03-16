import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 16.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2606
 * @mem 11664kb
 * @time 80ms
 * @caution S3, dfs
 */

public class 2606_바이러스 {

	static List<Integer>[] list;
	static boolean[] visited;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			list[from].add(to);
			list[to].add(from);
		}
		
		dfs(0);
		
		System.out.println(cnt-1);
	}

	static void dfs(int start) {
		if(visited[start]) return;
		
		visited[start] = true;
		cnt++;
		for (int x : list[start]) {
			if(!visited[x]) 
				dfs(x);
		}
	}
	
}