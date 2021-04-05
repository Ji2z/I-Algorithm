import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 5.
* @author Jin
* @see https://www.acmicpc.net/problem/1967
* @mem 128568kb / 19656kb
* @time 1892ms / 160ms
* @caution G4 두번째 방법이 10배 빠르다.
*/

public class 1967_트리의지름 {

	static int N, answer, max_idx;
	static List<int[]>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		list = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int leaf = 0; // 이 번호 다음으로 모두 리프노드
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int parent = Integer.parseInt(st.nextToken())-1;
			int child = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			list[parent].add(new int[]{child, weight});
			list[child].add(new int[]{parent, weight});
			leaf = parent;
		}

		// 첫번째 풀이 : 리프노드 사용
//		for (int i = leaf+1; i < N; i++) {
//			visited = new boolean[N];
//			dfs(i, 0);
//		}

		// 두번재 풀이 : 루트에서 가장 먼 노드 찾고 그 노드 기준으로 가장 먼 노드 찾기		
		dfs(0,0);
		visited = new boolean[N];
		dfs(max_idx, 0);
		
		System.out.println(answer);
	}

	static void dfs(int start, int sum) {
		// 첫번째 풀이
		//answer = Math.max(answer, sum);

		// 두번째 풀이
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