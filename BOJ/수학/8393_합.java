import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/8393
* @mem 18296kb
* @time 224ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}