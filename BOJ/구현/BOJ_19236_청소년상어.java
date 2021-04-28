import java.io.*;
import java.util.*;

/**
* @since 2021. 4. 28.
* @author Jin
* @see https://www.acmicpc.net/problem/19236
* @mem 11668kb
* @time 80ms
* @caution G2
*/

public class BOJ_19236_청소년상어 {

	static int answer;
	static int[][] deltas = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	
	static class UnderTheSea{
		int sum; // 먹은 물고기 합
		int[] shark; // 상어 위치 i, j
		int[][] info; // 1번~16번 상어 위치, 방향
		int[][] map; // 맵
		
		public UnderTheSea() {
			sum = 0;
			shark = new int[3];
			info = new int[16][3]; // 0:x, 1:y, 2:d
			map = new int[4][4];
		}

		public UnderTheSea(int sum, int[] shark, int[][] info, int[][] map) {
			super();
			this.sum = sum;
			this.shark = shark;
			this.info = info;
			this.map = map;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		UnderTheSea uds = new UnderTheSea();
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 4; j++) {
				int number = Integer.parseInt(st.nextToken())-1;
				int direction = Integer.parseInt(st.nextToken())-1;
				
				uds.map[i][j] = number;
				uds.info[number][0] = i;
				uds.info[number][1] = j;
				uds.info[number][2] = direction;
			}
		}
		
		answer = Integer.MIN_VALUE;
		eat(0, 0, uds);

		System.out.println(answer);
	}
	
	static void eat(int r, int c, UnderTheSea uds) {
		// 복사
		//UnderTheSea tuds = new UnderTheSea();
		int[][] info = copy(uds.info);
		int[][] map = copy(uds.map);
		// 먹음
		//System.out.println(r+", "+c);
		int fishN = map[r][c];
		int sum = (uds.sum+fishN+1);
		// 상어 자리잡기
		map[uds.shark[0]][uds.shark[1]] = -1; // 있던 칸 빈칸 처리
		int[] shark = new int[3];
		shark[0] = r;
		shark[1] = c;
		shark[2] = info[fishN][2];
		map[r][c] = 100; // 상어
		// 사라짐
		info[fishN][0] = -1;
		
		// 물고기들 이동
		for (int i = 0; i < 16; i++) {
			if(info[i][0]==-1)
				continue;
			
			int[] fish = info[i];
			for (int d = 0; d < 8; d++) {
				int nr = fish[0] + deltas[(fish[2]+d)%8][0];
				int nc = fish[1] + deltas[(fish[2]+d)%8][1];
				
				if(isIn(nr, nc)&&map[nr][nc]!=100) {
					int tempN = map[nr][nc];
					if(tempN == -1) { // 갈 수 있는곳이 빈칸
						map[fish[0]][fish[1]] = -1; // 있던 칸 빈칸
					}else {
						info[tempN][0] = fish[0];
						info[tempN][1] = fish[1];
						map[fish[0]][fish[1]] = tempN; // 바꾸기
					}
					map[nr][nc] = i; // 물고기 옮겨감
					info[i][0] = nr;
					info[i][1] = nc;
					info[i][2] = (fish[2]+d)%8;
					break;
				}
			}
		} // 이동 완료
		
		//갈수있는곳 탐색
		int cnt = 1;
		int nr = r+deltas[shark[2]][0];
		int nc = c+deltas[shark[2]][1];
		while(isIn(nr,nc)) {
			if(map[nr][nc] != -1) {
				//System.out.println(nr+", "+nc+", "+sum +", "+(map[nr][nc]+1));
				UnderTheSea tuds = new UnderTheSea(sum, shark, info, map);
				eat(nr, nc, tuds);
			}
			cnt++;
			nr = r+deltas[shark[2]][0]*cnt;
			nc = c+deltas[shark[2]][1]*cnt;
		}
		
		answer = Math.max(answer, sum);
		
	}
	
	static boolean isIn(int nr, int nc) {
		return 0<=nr&&nr<4&&0<=nc&&nc<4;
	}
	
	static int[][] copy(int[][] origin){
		int[][] result = new int[origin.length][origin[0].length];
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[0].length; j++) {
				result[i][j] = origin[i][j];
			}
		}
		return result;
	}

}
