import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/10808
* @mem 19572kb
* @time 248ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] arr = new int[26];
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			int a = str.charAt(i) - 97;
			arr[a]++;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.printf(arr[i] + " ");
		}

	}
}