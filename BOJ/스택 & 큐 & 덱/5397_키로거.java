import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/5397
 * @mem 223252kb
 * @time 1172ms
 * @caution LinkedList, ArrayDeque, List 모두 시간초과가 나온다.. 
 */

public class 5397_키로거 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");	
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			Stack<Character> pwdL = new Stack<>();		
			Stack<Character> pwdR = new Stack<>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(c=='<') {
					if(!pwdL.isEmpty())
						pwdR.push(pwdL.pop());
				}else if(c=='>') {
					if(!pwdR.isEmpty())
						pwdL.push(pwdR.pop());
				}else if(c=='-') {
					if(!pwdL.isEmpty())
						pwdL.pop();
				}else {
					pwdL.push(c);
				}
			}
			for (int j = 0; j < pwdL.size(); j++) {
				output.append(pwdL.get(j));
			}
			while(!pwdR.isEmpty()) {
				output.append(pwdR.pop());
			}
			output.append("\n");
		}	
		System.out.println(output);
	}
}