import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* @since 2021. 2. 17.
* @author Jin
* @see https://www.acmicpc.net/problem/1662
* @mem 16464kb
* @time 152ms
* @caution 1(2(00)2(11))2(00)
*/

public class 압축_1662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		Stack<List<Integer>> num = new Stack<>();
		
		int len = 0;
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==')') {
				int sublen = 0;
				while(true) {
					if(stack.peek()=='(') {
						stack.pop();
						int again = Integer.parseInt(stack.pop()+"");	
						if(!flag) {
							for(int pk = 0; pk < num.peek().size(); pk++) 
								sublen += num.peek().get(pk);
						}
						num.pop();
						sublen *= again;
						if(!stack.contains('(')) {
							len += sublen;
						}
						else num.get(num.size()-1).add(sublen);
						break;
					}
					else {
						stack.pop();
						sublen++;
						}
				}
				
				flag = false;
			}else if(s.charAt(i)=='(') {
				num.push(new ArrayList<Integer>());
				flag = true;
				stack.push(s.charAt(i));	
			}else stack.push(s.charAt(i));			
		}
		
		if(!stack.isEmpty()) 
			len += stack.size();
			
		System.out.println(len);
	}
}

