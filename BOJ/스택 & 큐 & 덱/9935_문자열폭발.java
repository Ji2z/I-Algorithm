import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
* @since 2021. 2. 17.
* @author Jin
* @see https://www.acmicpc.net/problem/9935
* @mem 63844kb
* @time 592ms
* @caution String.replace를 쓰면 메모리 초과, 계속 뒤돌아가서 탐색하면 시간 초과
*/

public class 문자열_폭발_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String bomb = br.readLine();

		int len = bomb.length();
		Stack<Character> stack = new Stack<>();
		int idx = 0;
		for (int i = 0; i < s.length(); i++, idx++) {
			stack.push(s.charAt(i));
			for (int j = 0; stack.size()>=len && j < len; j++) {
				if(stack.get(idx-j) != bomb.charAt(len-1-j))
					break;
				if(j+1==len) {
					for (int j2 = 0; j2 < len; j2++) {
						stack.pop();
						--idx;
					}
				}
			}
		}

		StringBuilder output = new StringBuilder("");
		if (stack.isEmpty())
			System.out.println("FRULA");
		else {
			for (int i = 0; i < stack.size(); i++) {
				output.append(stack.get(i));
			}
			System.out.println(output);
		}
	}
}
