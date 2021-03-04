import java.util.*;

/**
* @since 2021. 3. 4.
* @author Jin
* @see https://www.acmicpc.net/problem/2753
* @mem 18364kb
* @time 224ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		if (a % 4 == 0 && a % 100 != 0) {
			System.out.println("1");
		} else if (a % 400 == 0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}
}