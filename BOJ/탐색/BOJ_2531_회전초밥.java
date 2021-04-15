import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 15.
* @author Jin
* @see https://www.acmicpc.net/problem/2531
* @mem 16404kb
* @time 160ms
* @caution S1 = 정올 2577번 -> 정올이 시간제한이 더 빡셈.
*/

public class BOJ_2531_회전초밥 {

	static int N, D, K, C;
	static int[] bap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		bap = new int[N];
		for (int i = 0; i < N; i++) {
			bap[i] = Integer.parseInt(br.readLine());
		}

		int[] visited = new int[D+1];
		
		int answer = 0;
		int cnt = 0;
		
		for (int i = 0; i < K; i++) {
			if(visited[bap[i]]==0) cnt++;
			visited[bap[i]]++;
		}
		
		answer = cnt;
		
		for (int i = 1; i < N; i++) {
			if(answer <= cnt) {
				if(visited[C]==0)
					answer = cnt + 1;
				else
					answer = cnt;
			}
			visited[bap[i-1]]--;
			if(visited[bap[i-1]] == 0) cnt--;
			if(visited[bap[(i+K-1)%N]] == 0) cnt++;
			visited[bap[(i+K-1)%N]]++;
		}

		System.out.println(answer);
	}
}
