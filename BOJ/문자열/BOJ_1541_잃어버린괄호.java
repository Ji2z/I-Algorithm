import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 13.
* @author Jin
* @see https://www.acmicpc.net/problem/1541
* @mem 11616kb
* @time 76ms
* @caution S2 그리디
*/

public class BOJ_1541_잃어버린괄호 {
	
	static List<Integer> numbers;
	static List<Character> operators;
	static String s;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		s = br.readLine();
		numbers = new ArrayList<>();
		operators = new ArrayList<>();
		
		Stack<Integer> num = new Stack<>();
		Stack<Character> oper = new Stack<>();
		
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='+'||c=='-') {
				operators.add(c);
				numbers.add(Integer.parseInt(s.substring(idx,i)));
				idx = i+1;
			}
		}
		numbers.add(Integer.parseInt(s.substring(idx)));
		
		num.add(numbers.get(0));
		for (int i = 0; i < operators.size(); i++) {
			if(operators.get(i)=='+') {
				int temp = num.pop();
				temp += numbers.get(i+1);
				num.add(temp);
			}else {
				num.add(numbers.get(i+1));
			}
		}
		
		int answer = 0;
		while(num.size()>1) {
			answer -= num.pop();
		}
		
		System.out.println(answer+num.pop());
	}
	
}
