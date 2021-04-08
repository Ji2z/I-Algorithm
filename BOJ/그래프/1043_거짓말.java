import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 4. 9.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1043
 * @mem 11600kb
 * @time 104ms
 * @caution G4
 */

public class 1043_거짓말 {

	static int N, M;
	static int[] parent;
	
	static int findSet(int a) {
		if(parent[a] == a)
			return a;
		return parent[a] = findSet(parent[a]);
	}
	
	static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if(a==b)
			return false;
		if(b==0)
			parent[a] = b;
		else
			parent[b] = a;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int trueperson = Integer.parseInt(st.nextToken());
		for (int i = 0; i < trueperson; i++) {
			union(0,Integer.parseInt(st.nextToken()));
		}
		
		int[] party = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int people = Integer.parseInt(st.nextToken());
			
			if(people > 0) {
				int person = Integer.parseInt(st.nextToken());
				int root = findSet(person);
				party[i] = root;
				for (int j = 1; j < people; j++) {
					int p = Integer.parseInt(st.nextToken());
					int rootP = findSet(p);
					union(root,rootP);
				}
			}else
				party[i] = -1;
		}
		
		int answer = M;
		for (int i = 0; i < M; i++) {
			if(party[i] == -1) continue;
			if(findSet(party[i])==0) answer--;
		}
		
		System.out.println(answer);
	}

}