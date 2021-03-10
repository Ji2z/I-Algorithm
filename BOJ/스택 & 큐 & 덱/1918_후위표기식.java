import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 10.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1918
 * @mem 11504kb
 * @time 92ms
 * @caution 후위표기식... 참고블로그: https://summer-story.tistory.com/13
 */

public class 1918_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");

		String s = br.readLine();
		Stack<Character> stk = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')') {
				if(stk.isEmpty())
					stk.push(c);
				else {
					if(c=='+'||c=='-'){ // +, - 들어올 때
						while(!stk.isEmpty()&&stk.peek()!='(') {
							output.append(stk.pop());
						}
						stk.push(c);		
					} // +, - 들어올 때
					else if(c=='*'||c=='/') { // *, / 들어올 때
						if((stk.peek()=='+'||stk.peek()=='-'||stk.peek()=='('))
							stk.push(c);
						else {
							output.append(stk.pop());
							stk.push(c);
						}
					}// *, / 들어올 때
					else if(c==')') {
						while(!stk.isEmpty()&&stk.peek()!='(') {
							output.append(stk.pop());
						}
						stk.pop();
					}else { // ( 들어올 때
						stk.push(c);
					}
				}
			}else {
				output.append(c);
			}
		}
		if(!stk.isEmpty()) {
			while(!stk.isEmpty())
				output.append(stk.pop());
		}
		System.out.println(output);
	}
}