import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 26.
* @author Jin
* @see https://www.acmicpc.net/problem/17143
* @mem 23952kb
* @time 1980ms
* @caution G2
*/

public class BOJ_17143_낚시왕 {
	
	static int R, C, M, answer;
	static int[][] map;
	static int[][] deltas = {{-1,0 },{1,0},{0,1},{0,-1}};
	static Shark[] list;
	
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		R = Integer.parseInt(st.nextToken()); // 가로
		C = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		
		list = new Shark[M];
		map = new int[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			list[i] = new Shark(r, c, s, d, z);
			map[r][c] = i+1;
		}
		
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				if(map[i][j] != 0) {
					Shark got = list[map[i][j]-1];
					answer += got.z;
					map[i][j] = 0;
					got.r = -1;
					got.c = -1;
					break;
				}
			}
			map = move();
		}
		System.out.println(answer);
	}
	
	static int[][] move() {
		int[][] test = new int[R][C];
		for (int i = 0; i < M; i++) {
			Shark shark = list[i];
			if(shark.r != -1) {
				int nr = shark.r, nc = shark.c;
				for (int dist = 1; dist <= shark.s; dist++) {
					nr = nr + deltas[shark.d][0];
					nc = nc + deltas[shark.d][1];
					
					if(!isIn(nr, nc)) {
						int d = shark.d%2==0?shark.d+1:shark.d-1;
						shark.d = d;
						nr = nr + deltas[shark.d][0]*2;
						nc = nc + deltas[shark.d][1]*2;
					}
				}
				
//				if(shark.d==0 || shark.d==1) {
//					nr = Math.abs((nr+deltas[shark.d][0]*shark.s) % (2*R));
//					if(nr>=R)
//						shark.d = shark.d%2==0?shark.d+1:shark.d-1;
//					nr = (R-Math.abs(nr-R));
//				}else {
//					nc = Math.abs((nc+deltas[shark.d][1]*shark.s) % (2*C));
//					if(nc>=C)
//						shark.d = shark.d%2==0?shark.d+1:shark.d-1;
//					nc = (C-Math.abs(nc-C));
//				}
							
				if(test[nr][nc] != 0) {
					Shark temp = list[test[nr][nc]-1];
					if(shark.z>temp.z) {
						test[nr][nc] = i+1;
						temp.r = -1;
						temp.c = -1;
						shark.r = nr;
						shark.c = nc;
					}else {
						shark.r = -1;
						shark.c = -1;
					}
				}else {
					test[nr][nc] = i+1;
					shark.r = nr;
					shark.c = nc;
				}
			}
		}
		return test;
	}
	
	static boolean isIn(int nr, int nc) {
		return 0<=nr&&nr<R&&0<=nc&&nc<C;
	}
	
}
