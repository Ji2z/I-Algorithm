import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 29.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1755
 * @mem 11556kb
 * @time 80ms
 * @caution S5
 */

public class 1755_숫자놀이 {

	static class Number implements Comparable<Number>{
		String numS;
		int num;
		
		public Number(String numS, int num) {
			super();
			this.numS = numS;
			this.num = num;
		}
		
		@Override
		public int compareTo(Number o) {
			return this.numS.compareTo(o.numS);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		List<Number> list = new ArrayList<>();
		for (int i = M; i <= N; i++) {
			if(i<10) {
				int one = i;
				list.add(new Number(str[one],i));
			}else {
				int one = i%10;
				int ten = i/10;
				list.add(new Number(str[ten]+" "+str[one], i));
			}
		}
		
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			output.append(list.get(i).num).append(" ");
			if(i%10==9)
				output.append("\n");
		}
		
		System.out.println(output);
	}
}