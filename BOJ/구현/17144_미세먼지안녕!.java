import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 14.
* @author Jin
* @see https://www.acmicpc.net/problem/17144
* @mem 94256kb
* @time 372ms
* @caution G5 사방탐색 + 배열돌리기 = 시뮬
*/

public class 17144_미세먼지안녕! {

	static int R, C, T, uaI, uaJ, daI, daJ;
	static int[][] map;
	static int answer = 0;
	static int[][] deltasU = {{0,1},{1,0},{0,-1},{-1,0}};
	static int[][] deltasD = {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(uaI==0) {
						uaI = i;
						uaJ = j;
					}else {
						daI = i;
						daJ = j;
					}
				}
				else {
					answer += map[i][j];		
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			map = spread();
			rotate();
		}
		
		System.out.println(answer);
	}
	
	static int[][] spread(){
		int[][][] spmap = new int[R][C][2];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1) {					
					for (int d = 0; d < 4; d++) {
						int nr = i + deltasU[d][0];
						int nc = j + deltasU[d][1];
						
						if(isin(nr, nc)&&map[nr][nc] != -1) {
							spmap[i][j][0] += (map[nr][nc]/5);
							spmap[i][j][1]++;
							//System.out.println(i+", "+j+" : "+d+" = "+spmap[i][j][0]+", "+spmap[i][j][1]);
						}
					}
				}
			}
		}
		
		int[][] nmap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1) {
					nmap[i][j] = (map[i][j]-(map[i][j]/5)*spmap[i][j][1]) + spmap[i][j][0];
				}else
					nmap[i][j] = -1;
			}
		}
		
		return nmap;
	}
	
	static void rotate() {
		
		int direct = 0;
		int x = 0;
		int y = 0;
		int temp = map[x][y];
		while(direct < 4) {
			int nr = x + deltasU[direct][0];
			int nc = y + deltasU[direct][1];
			//System.out.println(direct+" : "+nr+", "+nc);
			if(isin(nr, nc) && nr<=uaI) {
				//System.out.println(x+", "+y);
				if(x == uaI && y == uaJ) {
					answer -= map[nr][nc];
				}else if(nr == uaI && nc == uaJ) {
					map[x][y] = 0;
				}else {
					map[x][y] = map[nr][nc];
				}
				x = nr;
				y = nc;
			}else direct++;
		}
		map[1][0] = temp;
		
		direct = 0;
		x = R - 1;
		y = C - 1;
		temp = map[x][y];
		while(direct < 4) {
			int nr = x + deltasD[direct][0];
			int nc = y + deltasD[direct][1];
			if(isin(nr, nc) && nr>=daI) {
				if(x == daI && y == daJ) {
					answer -= map[nr][nc];
				}else if(nr == daI && nc == daJ) {
					map[x][y] = 0;
				}else {
					map[x][y] = map[nr][nc];
				}
				x = nr;
				y = nc;
			}else direct++;
		}
		map[R-1][C-2] = temp;
		
	}

	static boolean isin(int nr, int nc) {
		return 0<=nr&&nr<R&&0<=nc&&nc<C;
	}
}

