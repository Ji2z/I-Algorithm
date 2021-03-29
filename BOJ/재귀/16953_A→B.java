import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 29.
 * @author Jin
 * @see https://www.acmicpc.net/problem/16953
 * @mem 11876kb
 * @time 88ms
 * @caution S1
 */

public class 16953_A→B {

	static long A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		check(A, 1);
		System.out.println(-1);
	}
	
	static void check(long sum, long cnt) {
		if(sum > B) return;
		if(sum == B) {
			System.out.println(cnt);
			System.exit(0);
		}
		check(sum*2, cnt+1);
		check(sum*10+1, cnt+1);
	}
}