import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 9.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1874
 * @mem 27904kb
 * @time 308ms
 * @caution
 */

public class 1874_스택수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		int check = 0;
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			for (int j = check+1; j <= num; j++) {
				stk.push(j);
				check=j;
				output.append("+\n");
			}
			while(!stk.isEmpty()&&stk.peek()==num) {
				stk.pop();
				output.append("-\n");
			}
		}
		if(!stk.isEmpty())
			output = new StringBuilder("NO");
		System.out.println(output);
	}
}