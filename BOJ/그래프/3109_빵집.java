import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2
* @author Jin
* @see https://www.acmicpc.net/problem/3109
* @mem 39448kb
* @time 444ms
* @caution 그래프 + 그리디
*/

public class Main {

	static int R, C, cnt = 0;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		makePipe();
		System.out.println(cnt);
	}
	
	private static void makePipe() {
		cnt = 0;
		// 윗행부터 시도
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i, 0);
		}
		
	}
	
	static int[] dr = {-1,0,1}; // 열은 무조건 오른쪽으로만 한칸 가므로 행관련 델타 값만 만든다.
	private static boolean dfs(int r, int c) { // 현재 탐색 위치를 매개변수로 받는다.
		
		if(c == C-1) {
			cnt++;
			return true;
		}
		
		int nr, nc = c+1;
		for (int d = 0; d < 3; d++) {
			nr = r + dr[d];
			// 범위가 벗어났거나, 건물이 있거나, 파이프가 지나가거나 혹은 이미 시도를 했는데 안되는 길인 경우
			if(nr<0 || nr>=R || map[nr][nc] == 'x' || visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			if(dfs(nr, nc)) return true; // 한 번 파이프 놓기에 성공했다면 그거 그대로 고정! 끝! 더 이상 다른 방향으로 시도하지 않는다.
			// visited[nr][nc] = false; => 실패했던 흔적을 되돌리지 않기!! (가지치기 효과)
			// ↑ 뒤의 선택지의 방향은 현재보다 유리하지 않은 상황이고 결국 같은 상황이 되풀이 된다.
		}
		
		return false;
	}
	
	
}