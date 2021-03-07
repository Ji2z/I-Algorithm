import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/10828
* @mem 24248kb
* @time 324ms
* @caution
*/

public class 10828_스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			
			if(s.equals("push"))
				stack.push(Integer.parseInt(st.nextToken()));
			else if(s.equals("pop")) {
				if(stack.isEmpty())
					output.append(String.format("%d\n", -1));	
				else
					output.append(String.format("%d\n", stack.pop()));	
			}
			else if(s.equals("size"))
				output.append(String.format("%d\n", stack.size()));	
			else if(s.equals("empty")) {
				if(stack.isEmpty())
					output.append(String.format("%d\n", 1));
				else
					output.append(String.format("%d\n", 0));
			}else if(s.equals("top")) {
				if(stack.isEmpty())
					output.append(String.format("%d\n", -1));
				else
					output.append(String.format("%d\n", stack.peek()));
			}			
		}
		
		System.out.println(output);
	}
}