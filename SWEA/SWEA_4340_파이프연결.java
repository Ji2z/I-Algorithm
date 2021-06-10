import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 10.
* @author Jin
* @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWL6LhM6A60DFAUY
* @mem 84,324 kb
* @time 233ms
* @caution d4
*/

public class SWEA_4340_파이프연결 {
	
	static int T, answer, N;
	static int[][] map;
	static boolean[][] visited0;
	static int[][][] deltas = {{},
								{{0,-1},{0,1}},
								{{-1,0},{1,0}},
								{{1,0},{0,1}}, // 아래, 오
								{{1,0},{0,-1}},
								{{0,-1},{-1,0}}, // 왼, 위
								{{-1,0},{0,1}}}; // 위, 오
	static int[][][] pipeD = {{},
								{{1,3,6},{1,4,5}}, // 왼, 오
								{{2,3,4},{2,5,6}}, // 위, 아래
								{{2,5,6},{1,4,5}},
								{{2,5,6},{1,3,6}},
								{{1,3,6},{2,3,4}},
								{{2,3,4},{1,4,5}}};
	static class Pipe implements Comparable<Pipe>{
		int x;
		int y;
		int num;
		int count;
		
		public Pipe(int x, int y, int num, int count) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.count = count;
		}
		
		@Override
		public String toString() {
			return "Pipe [x=" + x + ", y=" + y + ", num=" + num + ", count=" + count + "]";
		}

		@Override
		public int compareTo(Pipe o) {
			return Integer.compare(this.count, o.count);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 2501;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited0 = new boolean[N][N];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[n][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			if(map[0][0] == 1 || map[0][0] == 2)
				dfs(new Pipe(0, 0, 1, 1));
			else
				dfs(new Pipe(0, 0, 4, 1));
				
			
			
			output.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(output);
	}
	
	static void dfs(Pipe p) {
		//System.out.println(p);
		if(p.count > answer) return;
		if(p.x==N-1 && p.y==N-1 && (p.num==1 || p.num==6)) {
			//System.out.println(answer);
			answer = Math.min(answer, p.count);
			return;
		}
		
		for (int d = 0; d < deltas[p.num].length; d++) {
			int nr = p.x + deltas[p.num][d][0];
			int nc = p.y + deltas[p.num][d][1];
			
			if(isIn(nr, nc) && !visited0[nr][nc] && map[nr][nc] != 0) {
				visited0[nr][nc] = true;
				if(map[nr][nc] == 1 || map[nr][nc] == 2) {
					dfs(new Pipe(nr, nc, pipeD[p.num][d][0], p.count+1));
					visited0[nr][nc] = false;
				}else {
					dfs(new Pipe(nr, nc, pipeD[p.num][d][1], p.count+1));
					dfs(new Pipe(nr, nc, pipeD[p.num][d][2], p.count+1));
					visited0[nr][nc] = false;
				}
			}
		}
	}
	
	static boolean[][] copy(boolean[][] origin) {
		boolean[][] result = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = origin[i][j];				
			}
		}
		return result;
	}
	
	static boolean isIn(int nr, int nc) {
		return 0<=nr&&nr<N&&0<=nc&&nc<N;
	}
}
