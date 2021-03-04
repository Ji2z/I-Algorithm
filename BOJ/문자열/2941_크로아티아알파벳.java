import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/2941
* @mem 11644kb
* @time 96ms
* @caution
*/

public class 크로아티아_알파벳_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		s = s.replace("c=", ".");
		s = s.replace("c-", ".");
		s = s.replace("dz=", ".");
		s = s.replace("d-", ".");
		s = s.replace("lj", ".");
		s = s.replace("nj", ".");
		s = s.replace("s=", ".");
		s = s.replace("z=", ".");
		
		
		System.out.println(s.length());
	}
}
