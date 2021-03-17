import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 17.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2210
 * @mem 24104kb
 * @time 548ms
 * @caution S2
 */

public class 2210_숫자판점프 {

	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		list = new ArrayList<>();
		map = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 6, "");
			}
		}

		System.out.println(list.size());
	}

	static void dfs(int r, int c, int toChoose, String numS) {
		if(toChoose == 0) {
			int num = Integer.parseInt(numS);
			if(!list.contains(num))
				list.add(num);
			return;
		}
		
		for (int i = 0; i < delta.length; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];
			
			if(0<=nr&&nr<5&&0<=nc&&nc<5) {
				dfs(nr, nc, toChoose-1, numS+map[nr][nc]);
			}
		}
	}
}