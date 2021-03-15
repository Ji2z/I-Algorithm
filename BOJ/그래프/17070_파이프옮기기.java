import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 15.
 * @author Jin
 * @see https://www.acmicpc.net/problem/17070
 * @mem 16116kb
 * @time 188ms
 * @caution G5 
 */

public class 17070_파이프옮기기 {
	
	static int[][] map;
	static int cnt = 0;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 맵 정보 받아오기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가로:0, 세로:1, 대각선:2
		move(0, 0, 1);
				
		System.out.println(cnt);
	}
	
	static void move(int shp, int r, int c) {
		if(r==N-1 && c==N-1) {
			cnt++;
		}
		// 가로일 때
		switch(shp) {
		case 0:
			if(c+1<N && map[r][c+1]==0) {
				move(0, r, c+1);
				if(r+1<N && map[r+1][c]==0 && map[r+1][c+1]==0) {
					move(2, r+1, c+1);
				}
			}
			break;
		case 1:
			if(r+1<N && map[r+1][c]==0) {
				move(1, r+1, c);
				if(c+1<N && map[r][c+1]==0 && map[r+1][c+1]==0) {
					move(2, r+1, c+1);
				}
			}
			break;
		case 2:
			if(c+1<N && map[r][c+1]==0) {
				move(0, r, c+1);
			}
			if(r+1<N && map[r+1][c]==0) {
				move(1, r+1, c);
				if(c+1<N && map[r][c+1]==0 && map[r+1][c+1]==0) {
					move(2, r+1, c+1);
				}
			}
			break;
		}
	}
	
}