import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/10807
* @mem 18452kb
* @time 244ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int a, b;
		a = sc.nextInt();

		int[] arr = new int[a];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		b = sc.nextInt();

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == b) {
				count++;
			}
		}

		System.out.println(count);

	}
}