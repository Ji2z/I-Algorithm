import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 24.
* @author Jin
* @see https://www.acmicpc.net/problem/2098
* @mem 17612kb
* @time 468ms
* @caution G1 비트 마스킹
*/

public class 외판원순회 {
	
	static int N;
	static int[][] graph;
	static int INF = 987654321;
	// memo[i][status]: i번째 위치를 status 상태(이전 노드들에 대한 방문 정보)에서 방문했을 때
	// 나머지 도시들을 거쳐 출발지까지 가는 최소 비용
	static int[][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가로의 크기는 요소들의 방문 여부를 표현해주기 위한 크기
		memo= new int[N][1<<N];
		
		System.out.println(solve(0, 1<<0));
		
//		for (int[] row : memo) {
//			System.out.println(Arrays.toString(row));
//		}
	}
	
	/**
	 * @param cur 현재 내 위치
	 * @param visited 방문 이력 정보
	 * @return 거기서 출발점으로 가는 최소 비용
	 */
	static int solve(int cur, int visited) {
		// 이미 해당 상황을 처리한 값이 있을 경우 - 리턴
		if(memo[cur][visited] != 0)
			return memo[cur][visited];
		// 마지막 목적지까지 도착한 경우 - 출발지까지 갈 수 있다면 가기
		if(visited == (1<<N)-1) {
			if(graph[cur][0] != 0) {// 출발지랑 연결되어 있는지
				return graph[cur][0];
			}else { // 못 감
				return INF;
			}
		}
		// 나머지 경우 - 값을 찾아서 탐색
		memo[cur][visited] = INF;
		for (int i = 0; i < N; i++) {
			// 아직 미방문이고 그래프가 연결되어 있다면..
			if((visited & (1<<i)) == 0 && graph[cur][i] != 0) {
				memo[cur][visited] = Math.min(memo[cur][visited], solve(i, visited|(1<<i))+graph[cur][i]);
			}
		}
		return memo[cur][visited];
	}
}
