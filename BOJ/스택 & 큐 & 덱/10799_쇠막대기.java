import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 9.
 * @author Jin
 * @see https://www.acmicpc.net/problem/10799
 * @mem 14668kb
 * @time 136ms
 * @caution 
 */

public class 10799_쇠막대기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		Stack<Character> stk = new Stack<>();
		
		int answer = 0;
		char before = '(';
		stk.push(before);
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='(') {
				stk.push(c);
			}else {
				stk.pop();
				if(before=='(')  // 레이저
					answer += stk.size();
				else  // 쇠막대기 끝
					answer++;						
			}
			before = c;
		}

		System.out.println(answer);
	}
}