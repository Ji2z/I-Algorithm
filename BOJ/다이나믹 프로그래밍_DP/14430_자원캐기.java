import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 8.
 * @author Jin
 * @see https://www.acmicpc.net/problem/14430
 * @mem 20124kb
 * @time 192ms
 * @caution
 */

public class 14430_자원캐기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken()); // 세로길이
		int M = Integer.parseInt(st.nextToken()); // 가로길이
		
		// 맵 정보 받기
		int[][] map = new int[N+1][M+1];
		for (int i = 0; i <= N; i++) {
			if(i!=0)
				st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= M; j++) {
				if(i==0 || j==0) map[i][j] = 0;
				else map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = map[i][j]+Math.max(map[i][j-1],map[i-1][j]);
				answer = Math.max(answer, map[i][j]);
			}
		}

		System.out.println(answer);
	}
}