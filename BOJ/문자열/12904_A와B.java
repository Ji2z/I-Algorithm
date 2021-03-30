import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 3. 30.
 * @author Jin
 * @see https://www.acmicpc.net/problem/12904
 * @mem 11772kb
 * @time 92ms
 * @caution G5 역으로 생각하기
 */

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder("");
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		StringBuffer s = new StringBuffer(br.readLine());
		StringBuffer t = new StringBuffer(br.readLine());
		
		while(s.length()<t.length()) {
			if(t.charAt(t.length()-1)=='A') {
				t.deleteCharAt(t.length()-1);
			}else if(t.charAt(t.length()-1)=='B'){
				t.deleteCharAt(t.length()-1);
				t.reverse();
			}
		}
		
		if(s.toString().equals(t.toString()))
			System.out.println(1);
		else
			System.out.println(0);
	}
	
}