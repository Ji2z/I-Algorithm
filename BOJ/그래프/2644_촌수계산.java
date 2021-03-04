import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 3.
* @author Jin
* @see https://www.acmicpc.net/problem/2644
* @mem 11600kb
* @time 84ms
* @caution
*/

public class 촌수계산_2644 {
	
	static List<Integer>[] list;
	static boolean[] visited;
	static int a, b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[p].add(c);
			list[c].add(p);
		}
		
		visited = new boolean[N+1];
		find(a,0);
//		visited = new boolean[N+1];
//		find(b,0);
		
		if(CNT==0)
			System.out.println(-1);
		else
			System.out.println(CNT);
	}
	
	static int CNT;
	
	static void find(int start, int cnt) {
		if(visited[start])
			return;
		if(start == b) {
			CNT = cnt;
			return;
		}
		visited[start] = true;
		for (int i : list[start]) {
			if(!visited[i]) {
				find(i, cnt+1);
			}
		}
	}
}
