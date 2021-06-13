import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 13.
* @author Jin
* @see https://www.acmicpc.net/problem/18352
* @mem 287184kb
* @time 1248ms
* @caution S2
*/

public class BOJ_18352_특정거리의도시찾기 {
	
	static int N, M, K, X;
	static List<Integer>[] map;
	static boolean[] visited;
	static PriorityQueue<Integer> answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		
		visited = new boolean[N];
		answer = new PriorityQueue<>();
		
		map = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(st.nextToken())-1].add(Integer.parseInt(st.nextToken())-1);
		}
		
		bfs();
		if(answer.size()==0) {
			System.out.println(-1);
		}else {
			while(!answer.isEmpty()) {
				output.append(answer.poll()).append("\n");
			}
			System.out.println(output);
		}
		
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(X);
		visited[X] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			for (int s = 0; s < qsize; s++) {
				int from = queue.poll();
				if(cnt==K) {
					answer.add(from+1);
					continue;
				}
				
				for(int temp : map[from]) {
					if(!visited[temp]) {
						visited[temp] = true;
						queue.add(temp);
					}
				}
				
			}
			if(cnt==K) return;
			cnt++;
		}
	}

}
