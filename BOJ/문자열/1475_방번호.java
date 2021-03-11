import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1475
 * @mem 11500kb
 * @time 80ms
 * @caution S5
 */

public class 1475_방번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number = br.readLine();
		
		int answer = 0;
		int[] num = new int[10];
		for (int i = 0; i < number.length(); i++) {
			num[Integer.parseInt(number.charAt(i)+"")]++;
		}
		
		int sn = 0;
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			if(i==6||i==9)
				sn += num[i];
			else
				max = Math.max(max, num[i]);
		}
		
		sn = sn%2==0?sn/2:sn/2+1;
		answer = Math.max(max, sn);

		System.out.println(answer);
	}
}