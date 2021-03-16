import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 16.
* @author Jin
* @see https://www.acmicpc.net/problem/1759
* @mem 13248kb
* @time 84ms
* @caution G5
*/

public class 1759_암호만들기 {

	static List<Character> letters;
	static int L, C;
	static StringBuilder output;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		letters = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			char c = st.nextToken().charAt(0);
			letters.add(c);
		}

		Collections.sort(letters);
		comb(L, new char[L], 0);
		
		System.out.println(output);
	}

	static void comb(int toChoose, char[] choosed, int startIdx) {
		if(toChoose == 0) {
			int mo = 1;
			int ja = 2;
			Arrays.sort(choosed);
			
			boolean flag = false;
			for (int i = 0; i < choosed.length; i++) {
				char c = choosed[i];
				if (c == 'a' || c == 'i' || c == 'o' || c == 'u' || c == 'e')
					mo--;
				else
					ja--;
				if(mo<=0 && ja<=0) {
					flag = true;
					break;
				}
			}		
			if(!flag) return;
			
			for (int i = 0; i < choosed.length; i++) {
				output.append(choosed[i]);
			}
			output.append("\n");
			return;
		}
		
		for (int i = startIdx; i < C; i++) {
			choosed[L-toChoose] = letters.get(i);
			comb(toChoose-1, choosed, i+1);
		}
	}
}
