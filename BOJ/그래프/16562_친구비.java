import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 18.
 * @author Jin
 * @see https://www.acmicpc.net/problem/16562
 * @mem 17128kb
 * @time 180ms
 * @caution G3
 */

public class 16562_친구비 {

	static int N, M, K;
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

		if(rootA == rootB)
			return false;
		
		if (rank[rootA] <= rank[rootB]) {
			parents[rootB] = rootA;
		} else {
			parents[rootA] = rootB;
		}

		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 집합 만들기
		parents = new int[N + 1];
		rank = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
			rank[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionSet(a, b);
		}

		int money = 0;
		for (int i = 1; i <= N; i++) {
			if(parents[i] == i) {
				money += rank[i];
			}
		}
		
		if(K>=money)
			System.out.println(money);
		else
			System.out.println("Oh no");
	}

}