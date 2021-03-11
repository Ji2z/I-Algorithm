import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1021
 * @mem 11616kb
 * @time 80ms
 * @caution Deque을 쓰면 indexOf가 불가능하지만, LinkedList를 쓰면 가능하다.
 */

public class 1021_회전하는큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		LinkedList<Integer> que = new LinkedList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int curr = 1;
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int idx = que.indexOf(num)+1;
			int dist = Math.abs(curr-idx);
			if(dist <= Math.abs(que.size()-dist)) {
				for (int j = 0; j < dist; j++) {
					que.offer(que.poll());
					cnt++;
				}
			}else {
				for (int j = 0; j < Math.abs(que.size()-dist); j++) {
					que.offerFirst(que.pollLast());
					cnt++;
				}
			}
			que.poll();
			curr = 1;
		}
		
		System.out.println(cnt);
	}
}