import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 18.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1717
 * @mem 54972kb
 * @time 396ms
 * @caution G4
 */

public class 1717_집합의표현 {

	static int N, M;
	static int[] parents;
	static int[] rank;

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean unionSet(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);

		if (rootA == rootB)
			return false;

		if (rank[rootA] <= rank[rootB])
			parents[rootA] = rootB;
		else
			parents[rootB] = rootA;

		if (rank[rootA] == rank[rootB])
			rank[rootB]++;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 집합 만들기
		parents = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (p == 0) { // 합치기
				unionSet(a, b);
			} else { // 같은집합인지 확인 => 1 아니면 0
				int rootA = findSet(a);
				int rootB = findSet(b);
				if (rootA == rootB)
					output.append("YES\n");
				else
					output.append("NO\n");
			}
		}

		System.out.println(output);
	}

}