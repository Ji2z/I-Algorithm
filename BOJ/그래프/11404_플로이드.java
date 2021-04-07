import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 4. 7.
 * @author Jin
 * @see https://www.acmicpc.net/problem/11404
 * @mem 41896kb
 * @time 364ms
 * @caution G4 플로이드 워셜
 */

public class 11404_플로이드 {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 100001);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int pay = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(map[from][to], pay);
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i==k) continue;
				for (int j = 0; j < N; j++) {
					if(i==j||j==k||map[i][k]==100001||map[k][j]==100001)
						continue;
					else if(map[i][j]!=100001 && map[i][j] > map[i][k]+map[k][j])
						map[i][j] = map[i][k]+map[k][j];
					else if(map[i][j]==100001)
						map[i][j] = map[i][k]+map[k][j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==100001)
					output.append(0).append(" ");
				else
					output.append(map[i][j]).append(" ");
			}
			output.append("\n");
		}

		System.out.println(output);
	}

}