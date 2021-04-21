import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/15683
* @mem 25436kb
* @time 448ms
* @caution G5
*/

public class BOJ_15683_감시 {

	static int N, M, answer, zero;
	static int map[][][];
	static List<CCTV> list;
	static int[][] deltas = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } }; // 아, 왼, 위, 오

	static class CCTV{
		int x;
		int y;
		int type;
		int d;
		public CCTV(int x, int y, int type, int d) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M][9];
		list = new ArrayList<>();
		
		int starti = 0, startj = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j][8] = Integer.parseInt(st.nextToken());
				if(map[i][j][8]!=0 && map[i][j][8]!=6) {
					list.add(new CCTV(i, j, map[i][j][8], 0));
				}else if(map[i][j][8]==0)
					zero++;
			}
		}
		
		answer = Integer.MAX_VALUE;
		check(0);
		
		System.out.println(answer);
	}

	static void check(int idx) {
		if(idx == list.size()) {
			int cnt = zero;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int k = 0; k < list.size(); k++) {
						if(map[i][j][8]==0&&map[i][j][k]==7) {
							cnt--;
							break;
						}
					}
				}
			}
			answer = Math.min(answer, cnt);
			return;
		}
		
		CCTV cctv = list.get(idx);
		
		switch(cctv.type) {
		case 1:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[i][0]*j;
					int nc = cctv.y + deltas[i][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				
				check(idx+1);
				clear(idx);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[i][0]*j;
					int nc = cctv.y + deltas[i][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[i+2][0]*j;
					int nc = cctv.y + deltas[i+2][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				
				check(idx+1);
				clear(idx);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[i][0]*j;
					int nc = cctv.y + deltas[i][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[(i+1)%4][0]*j;
					int nc = cctv.y + deltas[(i+1)%4][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				
				check(idx+1);
				clear(idx);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[i][0]*j;
					int nc = cctv.y + deltas[i][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[(i+1)%4][0]*j;
					int nc = cctv.y + deltas[(i+1)%4][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[(i+2)%4][0]*j;
					int nc = cctv.y + deltas[(i+2)%4][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				
				check(idx+1);
				clear(idx);
			}
			break;
		case 5:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; ; j++) {
					int nr = cctv.x + deltas[i][0]*j;
					int nc = cctv.y + deltas[i][1]*j;
					
					if(isIn(nr, nc)&&map[nr][nc][8]!=6) {
						map[nr][nc][idx] = 7;
					}else break;
				}
				
			}
			
			check(idx+1);
			clear(idx);
			
			break;
		}
	}
	
	
	static void clear(int idx) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j][idx] = 0;
			}
		}
	}
	
	static boolean isIn(int nr, int nc) {
		return 0<=nr&&nr<N&&0<=nc&&nc<M;
	}
}
