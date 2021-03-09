import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 9.
 * @author Jin
 * @see https://www.acmicpc.net/problem/3986
 * @mem 18868kb
 * @time 312ms
 * @caution stack에 1개 남는 경우는 짝을 짓지 못하므로 실패!!
 */

public class 3986_좋은단어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int answer = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Stack<Character> stk = new Stack<>();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(!stk.isEmpty()) {
					if(c==stk.peek()) {
						while(!stk.isEmpty()&&c==stk.peek())
							stk.pop();
					}else
						stk.push(c);
				}else {
					stk.push(c);
				}
			}
			if(stk.isEmpty())
				answer++;
		}


		System.out.println(answer);
	}
}