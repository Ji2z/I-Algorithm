import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 19.
* @author Jin
* @see https://www.acmicpc.net/problem/17413
* @mem 23640kb
* @time 268ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		String s = br.readLine();
		Stack<Character> temp = new Stack<>();
		Stack<Character> stack = new Stack<>();

		//int cnt = 0;
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '<') {
				//cnt++;
				temp.push(c);
				flag = true;
			} else if (c == '>') {
				temp.push(c);
				//cnt++;
				int size = temp.size();
				//if (cnt >= 3) {
					if(!stack.isEmpty()) {
						int size2 = stack.size();
						for (int i2 = 0; i2 < size2; i2++) {
							output.append(stack.pop());
						}
					}
					for (int j = 0; j < size; j++) {
						output.append(temp.get(j));
					}
//				} else {
//					for (int j = 0; j < size; j++) {
//						output.append(temp.pop());
//					}
//				}
				temp.clear();
				//cnt = 0;
				flag = false;
			} else if (!flag) {
				if (c == ' ') {
					int size = stack.size();
					for (int j = 0; j < size; j++) {
						output.append(stack.pop());
					}
					output.append(" ");
				} else {
					stack.push(c);
				}
			} else {
				//cnt++;
				temp.push(c);
			}
		}

		if(!stack.isEmpty()) {
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				output.append(stack.pop());
			}
		}
		System.out.println(output);
	}

}