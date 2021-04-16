import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 16.
* @author Jin
* @see https://www.acmicpc.net/problem/17471
* @mem 13140kb
* @time 100ms
* @caution G5
*/

public class BOJ_17471_게리맨더링 {

	static int N, cnt;
	static List<Integer>[] link;
	static int[] people;
	static List<Info> list;
	static boolean[] checkA;
	static boolean[] checkB;

	public static class Info implements Comparable<Info> {
		int a;
		int b;
		boolean[] visited;

		public Info(int a, int b, boolean[] visited) {
			super();
			this.a = a;
			this.b = b;
			this.visited = visited;
		}

		@Override
		public String toString() {
			return "Info [a=" + a + ", b=" + b + ", visited=" + Arrays.toString(visited) + "]";
		}

		@Override
		public int compareTo(Info o) {
			int diff1 = Math.abs(a - b);
			int diff2 = Math.abs(o.a - o.b);
			return Integer.compare(diff1, diff2);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		people = new int[N];
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		link = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			link[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				link[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		
		power(N, new boolean[N]);
		Collections.sort(list);

		outer: for (int i = 0; i < list.size(); i++) {
			Info info = list.get(i);
			boolean[] infoB = info.visited;
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			checkA = new boolean[N];
			checkB = new boolean[N];

			for (int j = 0; j < infoB.length; j++) {
				if (infoB[j]) {
					A.add(j);
					checkB[j] = true;
				} else {
					B.add(j);
					checkA[j] = true;
				}
			}

			dfsA(A.get(0));
			for (int c = 0; c < checkA.length; c++) {
				if (!checkA[c])
					continue outer;
			}

			dfsB(B.get(0));
			for (int c = 0; c < checkB.length; c++) {
				if (!checkB[c])
					continue outer;
			}

			System.out.println(Math.abs(info.a - info.b));
			System.exit(0);
		}

		System.out.println(-1);
	}

	static void dfsA(int from) {
		checkA[from] = true;
		for (int to : link[from]) {
			if (!checkA[to])
				dfsA(to);
		}
	}

	static void dfsB(int from) {
		checkB[from] = true;
		for (int to : link[from]) {
			if (!checkB[to])
				dfsB(to);
		}
	}

	static void power(int toChoose, boolean[] visited) {
		if (cnt >= (1<<(N-1)))
			return;
		if (toChoose == 0) {
			int A = 0;
			int B = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					A += people[i];
				else
					B += people[i];
			}

			if (A != 0 && B != 0) {
				cnt++;
				list.add(new Info(A, B, copy(visited)));
			}
			return;
		}

		visited[N-toChoose] = false;
		power(toChoose - 1, visited);
		visited[N-toChoose] = true;
		power(toChoose - 1, visited);
	}
	
	static boolean[] copy (boolean[] b) {
		boolean[] copyb= new boolean[N];
		for (int i = 0; i < b.length; i++) {
			copyb[i] = b[i];
		}
		return copyb;
	}
}
