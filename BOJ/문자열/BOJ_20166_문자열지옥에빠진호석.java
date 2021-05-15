import java.io.*;
import java.util.*;

/**
 * @since 2021. 5. 15.
 * @author Jin
 * @see https://www.acmicpc.net/problem/20166
 * @mem 19092kb
 * @time 140ms
 * @caution G5
 */
public class BOJ_20166_문자열지옥에빠진호석 {

	static int N, M, K, cnt;
	static char[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		Map<String, Integer> wordmap = new HashMap<>();
		int[] words = new int[K];
		for (int k = 0; k < K; k++) {
			String word = br.readLine();
			cnt = 0;
			if(!wordmap.containsKey(word)) {
				char c = word.charAt(0);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(map[i][j] == c) {
							dfs(i, j, 1, word);
						}
					}
				}
				wordmap.put(word, cnt);
				words[k] = cnt;
			}else {
				words[k] = wordmap.get(word);
			}
			output.append(words[k]).append("\n");
		}
		
		System.out.println(output);
	}

	static void dfs(int n, int c, int idx, String s) {
		if(idx == s.length()) {
			cnt++;
			return;
		}
		
		for (int d = 0; d < deltas.length; d++) {
			int nr = n + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(!isIn(nr, nc)) {
				int[] temp = change(nr, nc);
				nr = temp[0];
				nc = temp[1];
			}
			
			if(map[nr][nc] == s.charAt(idx)) {
				dfs(nr, nc, idx+1, s);
			}
		}
	}

	static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < M;
	}
	
	static int[] change(int nr, int nc) {
		int temp[] = new int[2];
		temp[0] = nr;
		temp[1] = nc;
		
		if(nr==N) 
			temp[0] = 0;
		else if(nr==-1) 
			temp[0] = N-1;
		if(nc == M)
			temp[1] = 0;
		else if(nc==-1)
			temp[1] = M-1;
		return temp;
	}

}
