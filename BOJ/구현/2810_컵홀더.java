import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2. 26.
* @author Jin
* @see https://www.acmicpc.net/problem/2810
* @mem 11632kb
* @time 80ms
* @caution 그리디
*/

public class 컵홀더_2810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		s = s.replace('S', '.');
		s = s.replace("LL", ".");
		
		
		System.out.println(s.length()+1 > n ? n : s.length()+1);
	}	
}
