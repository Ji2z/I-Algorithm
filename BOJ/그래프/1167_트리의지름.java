import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 5.
* @author Jin
* @see https://www.acmicpc.net/problem/1167
* @mem 113668kb
* @time 824ms
* @caution G3 1967번과 비슷
*/

public class 1167_트리의지름 {

	static int N, answer, max_idx;
	static List<int[]>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		list = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0])-1;
			for (int j = 1; j < temp.length-1; j+=2) {
				int to = Integer.parseInt(temp[j])-1;
				int weight = Integer.parseInt(temp[j+1]);
				list[from].add(new int[]{to, weight});
				list[to].add(new int[]{from, weight});
			}
		}
	
		dfs(0,0);
		visited = new boolean[N];
		dfs(max_idx, 0);
		
		System.out.println(answer);
	}

	static void dfs(int start, int sum) {
		if(answer < sum) {
			max_idx = start;
			answer = sum;
		}
		
		visited[start] = true;
		for(int[] x: list[start]) {
			if(!visited[x[0]]) {
				dfs(x[0], sum + x[1]);
			}
		}
	}

}