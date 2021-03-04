import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2884
* @mem 19632kb
* @time 252ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int s = b - 45;

		if (s >= 0) {
			System.out.println(a + " " + s);
		} else {
			a -= 1;
			if (a < 0) {
				a = 23;
			}
			b = 60 + s;
			System.out.println(a + " " + b);
		}

	}
}