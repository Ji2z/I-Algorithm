import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/18258
 * @mem 327624kb
 * @time 1148ms
 * @caution 10845번과 코드가 동일하다.
 */

public class 18258_큐2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		Deque<Integer> que = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String s = st.nextToken();
			switch(s){
			case "push":
				que.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(que.isEmpty())
					output.append(-1).append("\n");
				else
					output.append(que.poll()).append("\n");
				break;
			case "size":
				output.append(que.size()).append("\n");
				break;
			case "empty":
				if(que.isEmpty())
					output.append(1).append("\n");
				else
					output.append(0).append("\n");
				break;
			case "front":
				if(que.isEmpty())
					output.append(-1).append("\n");
				else
					output.append(que.peek()).append("\n");
				break;
			case "back":
				if(que.isEmpty())
					output.append(-1).append("\n");
				else
					output.append(que.peekLast()).append("\n");
				break;
			}

		}
		
		System.out.println(output);
	}
}