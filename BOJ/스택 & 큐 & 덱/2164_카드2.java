import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2164
 * @mem 31540kb
 * @time 140ms
 * @caution 
 */

public class 2164_카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> que = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}
		while(que.size()>1) {
			que.poll();
			int num = que.poll();
			que.offerLast(num);
		}
		
		System.out.println(que.poll());
	}
}