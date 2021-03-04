import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2739
* @mem 19316kb
* @time 260ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		for (int i = 1; i < 10; i++) {
			System.out.println(a + " * " + i + " = " + a * i);
		}

	}
}