import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021. 3. 15.
 * @author Jin
 * @see https://www.acmicpc.net/problem/16637
 * @mem 11572kb
 * @time 76ms
 * @caution G3 변수 초기값을 신중하게 설정해야 한다.
 */

public class 16637_괄호추가하기 {

	static List<Character> ops;
	static List<Integer> nums;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		// 수식 저장용 리스트
		ops = new ArrayList<>();
		nums = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) {
			if(i%2==0)
				nums.add(Integer.parseInt(s.charAt(i)+""));
			else
				ops.add(s.charAt(i));
		}
		
		dfs(nums.get(0), 0);
				
		System.out.println(result);
	}
	
	static void dfs(int num, int opIdx) {
		if(opIdx>=ops.size()) {
			result = Math.max(result, num);
			return;
		}
		// 괄호가 없는경우
		int res1 = calc(num, nums.get(opIdx+1), ops.get(opIdx));
		dfs(res1, opIdx+1);
		
		// 괄호가 있는 경우
		if(opIdx+1<ops.size()) {
			int res2 = calc(nums.get(opIdx+1), nums.get(opIdx+2), ops.get(opIdx+1));
			dfs(calc(num, res2, ops.get(opIdx)),opIdx+2);
		}
	}
	
	static int calc(int a, int b, char op) {
		switch(op) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		}
		return 0;
	}
}