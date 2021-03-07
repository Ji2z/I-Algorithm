import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 7.
 * @author Jin
 * @see https://www.acmicpc.net/problem/9012
 * @mem 11664kb
 * @time 80ms
 * @caution
 */

public class 9012_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();

		boolean flag = false;
		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(')
					stack.push('(');
				else {
					if (!stack.isEmpty()) {
						char c = stack.pop();
						if (c != '(') {
							output.append("NO\n");
							flag = true;
							break;
						}
					} else {
						output.append("NO\n");
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				if (!stack.isEmpty())
					output.append("NO\n");
				else
					output.append("YES\n");
			}
			stack = new Stack<>();
			flag = false;
		}

		System.out.println(output);
	}
}