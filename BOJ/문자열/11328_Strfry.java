import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/11328
 * @mem 19620kb
 * @time 224ms
 * @caution B2 소문자 a는 97..
 */

public class 11328_Strfry {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int[] alph1 = new int[26];
			int[] alph2 = new int[26];
			String s = st.nextToken();
			for (int j = 0; j < s.length(); j++) {
				alph1[(int)s.charAt(j)-97]++;
			}
			s = st.nextToken();
			for (int j = 0; j < s.length(); j++) {
				alph2[(int)s.charAt(j)-97]++;
			}
			boolean flag = false;
			for (int j = 0; j < 26; j++) {
				if(alph1[j]!=alph2[j]) {
					flag = true;
					output.append("Impossible\n");
					break;
				}
			}
			if(!flag) output.append("Possible\n");
		}

		System.out.println(output);
	}
}