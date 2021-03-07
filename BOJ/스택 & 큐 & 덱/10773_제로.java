import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
* @since 2021. 3. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/10773
* @mem 21392kb
* @time 204ms
* @caution
*/

public class 10773_제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) 
				stack.push(num);
			else
				stack.pop();
		}
		
		int sum = 0;
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}