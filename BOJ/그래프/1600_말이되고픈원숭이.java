import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 24.
* @author Jin
* @see https://www.acmicpc.net/problem/1600
* @mem 78512kb
* @time 484ms
* @caution G5
*/

public class 1600_말이되고픈원숭이 {

	static int K, W, H, max;
	static int[][] map;
	static int[][] deltaH = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };
	static int[][] deltaM = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Monkey> queue;
	static boolean[][][] visited;

	static class Monkey{
		int row, col, horseMove;

		public Monkey(int row, int col, int horseMove) {
			super();
			this.row = row;
			this.col = col;
			this.horseMove = horseMove;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}

	static int bfs() {
		queue = new LinkedList<>();
		visited = new boolean[H][W][K+1];
		// 초기 상태
		queue.offer(new Monkey(0,0,0));
		visited[0][0][0] = true;
		
		int depth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size --> 0) {
				// 사용하기...
				Monkey head = queue.poll();
				
				// 목적지?
				if(head.row == H-1 && head.col == W-1) {
					return depth;
				}
				
				// 자식 탐색
				// 1. 원숭이로 이동
				moveLike(deltaM, head, true);
				// 2. 말로 이동 - 말로 이동할 수 있는 횟수가 남아있다면.. 말로 이동
				if(head.horseMove < K) { // 이동 횟수가 남아있다.
					moveLike(deltaH, head, false);
				}
			}
			
			// 턴이 하나 종료
			depth++;
		}
		
		return -1;
	}	
	
	static void moveLike(int[][] deltas, Monkey m, boolean isMonkey) {
		// 자식 탐색
		for (int i = 0; i < deltas.length; i++) {
			int nr = m.row + deltas[i][0];
			int nc = m.col + deltas[i][1];
			
			if(isIn(nr,nc) && map[nr][nc] == 0) {
				// 말로 이동인지.. 원숭이로 이동인지.. -> 원숭이의 말 이동 횟수가 달라진다.
				int horseMove = isMonkey? m.horseMove:m.horseMove+1;
				if(!visited[nr][nc][horseMove]) {
					Monkey newMonkey  = new Monkey(nr,nc,horseMove);
					queue.add(newMonkey);
					visited[nr][nc][horseMove] = true;
				}
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		if (0 <= r && r < H && 0 <= c && c < W)
			return true;
		return false;
	}
}
