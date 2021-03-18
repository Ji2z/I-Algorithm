import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 18.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1976
 * @mem 16160kb
 * @time 136ms
 * @caution G4
 */

public class 1976_여행가자 {

	static int N, M;
	static int[] parents;
	
	static int findSet(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static void unionSet(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA==rootB)
			return;
		parents[rootB] = rootA;
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					unionSet(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int root = findSet(Integer.parseInt(st.nextToken())-1);
		for (int i = 1; i < M; i++) {
			int temp = findSet(Integer.parseInt(st.nextToken())-1);
			if(root != temp) {
				System.out.println("NO");
				System.exit(0);
			}
		}

		System.out.println("YES");
	}

	
}