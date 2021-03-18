import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 19.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2583
 * @mem 12328kb
 * @time 88ms
 * @caution S1
 */

public class 2583_영역구하기 {
	
	static int M, N, K;
	static List<Integer> area;
	static boolean[][] map;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for (int x = lx; x < rx; x++) {
				for (int y = ly; y < ry; y++) {
					map[y][x] = true;
				}
			}
		}

		area = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!map[i][j])
					area.add(bfs(i, j));
			}
		}
		
		Collections.sort(area);
		
		output.append(area.size()).append("\n");
		for (int i = 0; i < area.size(); i++) {
			output.append(area.get(i)).append(" ");
		}
		
		System.out.println(output);
	}

	static int bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r, c});
		map[r][c] = true;
		
		int size = 1;
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int curri = curr[0];
			int currj = curr[1];
			for (int i = 0; i < 4; i++) {
				int nr = curri + delta[i][0];
				int nc = currj + delta[i][1];
				
				if(0<=nr && nr<M && 0<=nc && nc<N && !map[nr][nc]) {
					queue.offer(new int[] {nr, nc});
					map[nr][nc] = true;
					size++;
				}
			}
		}
		return size;
	}
	
}