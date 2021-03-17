import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 17.
 * @author Jin
 * @see https://www.acmicpc.net/problem/16236
 * @mem 18988kb
 * @time 232ms
 * @caution G4
 */

public class 16236_아기상어 {

	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int N, sr, sc;
	static int sec = 0, shark = 2, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if (a == 9) {
					sr = i;
					sc = j;
					map[i][j] = 0;
				}
			}
		}
		
		// 무한루프 => 이동거리 리턴 => 못찾으면 -1리턴 
		while (true) {
			int result = check(sr, sc);
			if(result<0)
				break;
			sec += result;
				
		}
		System.out.println(sec);
	}

	static int check(int r, int c) {
		int dist = 0;
		visited = new boolean[N][N];
		Queue<Point> queue = new LinkedList<>();
		Point p = new Point(r, c);
		queue.offer(p);
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int qsize = queue.size();		
			List<Point> list = new ArrayList<>();
			for (int s = 0; s < qsize; s++) {
				Point curr = queue.poll();

				if (map[curr.x][curr.y] < shark && map[curr.x][curr.y] != 0) {
					list.add(curr);
				}

				for (int i = 0; i < 4; i++) {
					int nr = curr.x + delta[i][0];
					int nc = curr.y + delta[i][1];

					if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
						if (map[nr][nc] <= shark) {
							visited[nr][nc] = true;
							queue.offer(new Point(nr, nc));
						}
					}
				}// 사방탐색 for
			}//qsize for
			
			if(list.size()!=0) {
				Collections.sort(list,(o1,o2)->{
					int diff = Integer.compare(o1.x, o2.x);
					return diff!=0?diff:Integer.compare(o1.y, o2.y);
				});
				
				map[list.get(0).x][list.get(0).y] = 0;
				cnt++;
				if (shark == cnt) {
					shark++;
					cnt = 0;
				}
				sr = list.get(0).x;
				sc = list.get(0).y;
				return dist;
			}
		
			dist++;
		}

		return -1;
	}

}