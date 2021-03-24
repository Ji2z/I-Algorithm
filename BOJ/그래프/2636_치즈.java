import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 24.
* @author Jin
* @see https://www.acmicpc.net/problem/2636
* @mem 12984kb
* @time 120ms
* @caution G5
*/

public class 2636_치즈 {
	
	static int N, M;
	static boolean[][] map;
	static boolean[][] visited;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static int cheese;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 1) {
					cheese++;
					map[i][j] = true; // 치즈
				}
				else
					map[i][j] = false; // 빈곳
			}
		}
		
		int cnt = 0;
		int cheeseCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && !map[i][j] && cheese > 0) {
					cheeseCnt = cheese;
					findBorder(i, j);
					cnt++;
					i = 0;
					j = -1;
					visited = new boolean[N][M];
				}
			}
		}
		
		System.out.println(String.format("%d\n%d\n", cnt, cheeseCnt));
	}
	
	static void findBorder(int r, int c) {
		visited[r][c] = true;
		
		for (int k = 0; k < 4; k++) {
			int nr = r + delta[k][0];
			int nc = c + delta[k][1];

			if(0<=nr&&nr<N&&0<=nc&&nc<M && !visited[nr][nc]) {
				if(!map[nr][nc]) // 빈곳이면 계속 탐색
					findBorder(nr, nc);
				else { // 치즈 만남
					visited[nr][nc] = true;
					map[nr][nc] = false; // 탐색은 그만하고 빈곳으로 바꿔줌
					cheese--;
				}
			}
		}
	}
	
}
