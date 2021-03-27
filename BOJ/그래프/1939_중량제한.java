import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 27.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1939
 * @mem 62508kb
 * @time 552ms
 * @caution G4 - 이분탐색 + dfs
 */

public class 1939_중량제한 {

	static int N, M, max, F, D;
	static List<Island>[] list;

	static class Island implements Comparable<Island>{

		int to, weight;
		
		public Island(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Island [to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Island o) {
			if(this.to == o.to) {
				int max = Math.max(this.weight, o.weight);
				if(max == this.weight) {
					o.to = -1;
					o.weight = -1;
				}else {
					this.to = -1;
					this.weight = -1;
				}
			}
			return Integer.compare(o.weight, this.weight);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];	
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[a].add(new Island(b,weight));
			list[b].add(new Island(a,weight)); // 양방향
			start = Math.min(start, weight);
			end = Math.max(end, weight);
		}
		//System.out.println(start+", "+end);
		for (int i = 0; i <= N; i++) {
			Collections.sort(list[i]);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken()); // 출발지
		D = Integer.parseInt(st.nextToken()); // 도착지
		
		int answer = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			if(dfs(new boolean[N+1], mid, F)) {
				start = mid + 1;
				answer = Math.max(answer, mid);
			}else {
				end = mid - 1;
			}
		}
		
		
		System.out.println(answer);
	}

	static boolean dfs(boolean[] visited, int we, int from) {
		if(visited[from]) return false;
		
		if(from == D) {
			return true;
		}
		
		visited[from] = true;
		for (Island i: list[from]) {
			if(i.weight>=we) {
				//dfs(visited, we, i.to);
				if(dfs(visited, we, i.to))
					return true;
			}
		}
		return false;
	}

}