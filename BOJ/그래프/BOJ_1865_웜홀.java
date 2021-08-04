import java.io.*;
import java.util.*;

/**
* @since 2021. 8. 4.
* @author Jin
* @see https://www.acmicpc.net/problem/1865
* @mem 19876kb
* @time 496ms
* @caution G4 벨만포드 알고리즘
*/

public class BOJ_1865_웜홀 {

	static int N, M, W;
	static List<int[]> list;
	static int[] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder output = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			
			for (int m = 0; m < M+W; m++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken())-1;
				int E = Integer.parseInt(st.nextToken())-1;
				int T = Integer.parseInt(st.nextToken());
				
				if(m<M) {
					list.add(new int[] {S, E, T});
					list.add(new int[] {E, S, T});
				}
				else
					list.add(new int[] {S, E, (T*-1)});
			}
			
			if(bellman())
				output.append("YES\n");
			else
				output.append("NO\n");
		}
		
		System.out.println(output);
	}

	static boolean bellman() {
		dist = new int[N];
		Arrays.fill(dist, 5000001);
		dist[0] = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < list.size(); j++) {
				int[] temp = list.get(j);
				if(dist[temp[0]]+temp[2]<dist[temp[1]]) {
					dist[temp[1]] = dist[temp[0]] + temp[2];
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			int[] temp = list.get(i);
			if(dist[temp[0]]+temp[2]<dist[temp[1]])
				return true;
		}
		
		return false;
	}
}
