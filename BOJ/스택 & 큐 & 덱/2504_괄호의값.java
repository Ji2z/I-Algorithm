import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @since 2021. 3. 9.
 * @author Jin
 * @see https://www.acmicpc.net/problem/2504
 * @mem 11936kb
 * @time 88ms
 * @caution
 */

public class 2504_괄호의값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		Stack<Character> stk = new Stack<>();
		List<List<Integer>> number = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[') {
				stk.push(c);
				if(stk.size()!=number.size())
					number.add(new ArrayList<Integer>());
			} else {
				if (!stk.isEmpty()) {
					if (c == ')' && stk.peek() == '(') {
						int sum = 2;
						if(stk.size()<number.size()) {
							sum = 0;
							for (int j = 0; j < number.get(number.size()-1).size(); j++) {
								sum += number.get(number.size()-1).get(j);
							}
							number.remove(number.size()-1);
							sum *= 2;
						}
						number.get(stk.size() - 1).add(sum);
						stk.pop();
					} else if (c == ']' && stk.peek() == '[') {
						int sum = 3;
						if(stk.size()<number.size()) {
							sum = 0;
							for (int j = 0; j < number.get(number.size()-1).size(); j++) {
								sum += number.get(number.size()-1).get(j);
							}
							number.remove(number.size()-1);
							sum *= 3;
						}
						number.get(stk.size() - 1).add(sum);
						stk.pop();
					}else {
						System.out.println(0);
						System.exit(0);
					}
				}else {
					System.out.println(0);
					System.exit(0);
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < number.get(0).size(); i++) {
			answer += number.get(0).get(i);
		}
		System.out.println(answer);
	}
}