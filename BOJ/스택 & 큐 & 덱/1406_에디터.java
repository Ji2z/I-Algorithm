import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1406
 * @mem 143436kb
 * @time 828ms
 * @caution 5397번과 유사
 */

public class 1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;		
		
		String s = br.readLine();
		Stack<Character> pwdL = new Stack<>();		
		Stack<Character> pwdR = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			pwdL.push(s.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			char c = st.nextToken().charAt(0);
			
			if(c=='L') {
				if(!pwdL.isEmpty())
					pwdR.push(pwdL.pop());
			}else if(c=='D') {
				if(!pwdR.isEmpty())
					pwdL.push(pwdR.pop());
			}else if(c=='B') {
				if(!pwdL.isEmpty())
					pwdL.pop();
			}else {
				pwdL.push(st.nextToken().charAt(0));
			}
		}
		
		for (int j = 0; j < pwdL.size(); j++) {
			output.append(pwdL.get(j));
		}
		while(!pwdR.isEmpty()) {
			output.append(pwdR.pop());
		}
		output.append("\n");
			
		System.out.println(output);
	}
}