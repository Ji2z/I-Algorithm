import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/10952
* @mem 18412kb
* @time 248ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		while(a!=0&&b!=0) {
			System.out.println(a+b);
			a = sc.nextInt();
			b = sc.nextInt();
		}
	}
}