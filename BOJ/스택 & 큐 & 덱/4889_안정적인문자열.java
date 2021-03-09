import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 10.
 * @author Jin
 * @see https://www.acmicpc.net/problem/4889
 * @mem 12784kb
 * @time 136ms
 * @caution
 */

public class 4889_안정적인문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		String s = br.readLine();
		for (int t = 1; s.charAt(0)!='-'; t++) {
			Stack<Character> stk = new Stack<>();
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(stk.isEmpty()) {
					if(c!='{')
						cnt++;
					stk.push('{');
				}else {
					if(c=='{')
						stk.push(c);
					else {
						if(stk.peek()=='{') 
							stk.pop();	
					}
				}
			}
			if(!stk.isEmpty())
				cnt += (stk.size()/2);
			output.append(String.format("%d. %d\n", t,cnt));
			// 새로운 문자열 갖고오기
			s = br.readLine();
		}
		
		System.out.println(output);
	}
}