import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 4. 9.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1238
 * @mem 18732kb
 * @time 1464ms
 * @caution G3
 */

public class 1238_파티 {

	static int N, M, X;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 100001);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;	
			int time = Integer.parseInt(st.nextToken());
			map[from][to] = time;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k==i) continue;
				for (int j = 0; j < N; j++) {
					if(i==j||j==k||map[i][k]==100001||map[k][j]==100001)
						continue;
					map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if(map[i][X]!=100001 && map[X][i] != 100001)
				answer = Math.max(answer, map[i][X]+map[X][i]);
		}
		
		System.out.println(answer);
	}

}