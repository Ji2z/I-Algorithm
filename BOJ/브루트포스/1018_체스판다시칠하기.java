import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 7.
* @author
* @see https://www.acmicpc.net/problem/1018
* @mem 14684kb
* @time 148ms
* @caution
*/

public class 1018_체스판다시칠하기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];

		for (int n = 0; n < N; n++) {
			board[n] = br.readLine().toCharArray();
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					for (int k2 = 0; k2 < 4; k2++) {
						char c = board[i][j];						
						if(board[i+2*k][j+2*k2]!=c) cnt++;
						if(board[i+2*k+1][j+2*k2+1]!=c) cnt ++;
						if(board[i+2*k+1][j+2*k2]==c) cnt++;
						if(board[i+2*k][j+2*k2+1]==c) cnt++;	
					}
				}
				cnt = Math.min(cnt, 64-cnt);
				min = Math.min(min, cnt);
			}
		}

		System.out.println(min);
	}
}
