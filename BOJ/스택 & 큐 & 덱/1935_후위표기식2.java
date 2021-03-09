import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 9.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1935
 * @mem 11832kb
 * @time 88ms
 * @caution float이 아닌 double로 해야 통과가 된다.
 */

public class 1935_후위표기식2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int[] alph = new int[N];	
		for (int i = 0; i < N; i++) {
			alph[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Double> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='+'||c=='-'||c=='*'||c=='/') {
				double a = stk.pop();
				double b = stk.pop();
				double result = 0;
				switch(c) {
				case '+':
					result = b+a;
					break;
				case '-':
					result = b-a;
					break;
				case '*':
					result = b*a;
					break;
				case '/':
					result = b/a;
					break;
				}
				stk.push(result);
			}else {
				stk.push((double)(alph[(int)c-65]));
			}
		}

		System.out.println(String.format("%.2f", stk.pop()));
	}
}