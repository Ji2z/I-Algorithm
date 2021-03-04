import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 17.
* @author Jin
* @see https://www.acmicpc.net/problem/17298
* @mem 155516kb
* @time 1096ms
* @caution
*/

public class 오큰수_17298 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] NGE = new int[N];
		Stack<int[]> stack = new Stack<>(); // [0]: 숫자, [1]: 인덱스  // 3 5 2 7 // [3,0] [5,1] [2,3] [7,4]
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) {
				stack.push(new int[] {num,i});
			}else {
				while(stack.peek()[0] < num) {
					NGE[stack.pop()[1]] = num;
					if(stack.isEmpty()) break;
				}
				stack.push(new int[] {num,i});
			}
		}
		
		while(!stack.isEmpty()) {
			NGE[stack.pop()[1]] = -1;
		}
		
		for (int i = 0; i < NGE.length; i++) 
			output.append(NGE[i]).append(" ");
		
		System.out.println(output);
	}
}
