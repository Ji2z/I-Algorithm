import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 9.
 * @author Jin
 * @see https://www.acmicpc.net/problem/4949
 * @mem 16408kb
 * @time 168ms
 * @caution
 */

public class 4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		String s = br.readLine();
		while(!s.equals(".")) {
			int size = s.length();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < size; i++) {
				char c = s.charAt(i);
				if(c=='('||c=='[')
					stack.push(c);
				else if(c==')') {
					if(stack.isEmpty()) {
						output.append("no\n");
						break;
					}else {
						if(stack.pop()!='(') {
							output.append("no\n");
							break;
						}
					}
				}else if(c==']') {
					if(stack.isEmpty()) {
						output.append("no\n");
						break;
					}else {
						if(stack.pop()!='[') {
							output.append("no\n");
							break;
						}
					}
				}
				if(i+1==size) {
					if(stack.isEmpty())
						output.append("yes\n");
					else
						output.append("no\n");
				}
			}// for
			s=br.readLine();
		}// while		

		System.out.println(output);
	}
}