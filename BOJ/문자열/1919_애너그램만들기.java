import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/1919
* @mem 18272kb
* @time 224ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str2 = sc.next();

		int[] arr = new int[26];
		int[] arr2 = new int[26];

		for (int i = 0; i < str.length(); i++) {
			int a = str.charAt(i) - 97;
			arr[a]++;
		}
		for (int i = 0; i < str2.length(); i++) {
			int a = str2.charAt(i) - 97;
			arr2[a]++;
		}
		int sub = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr2[i]) {
				sub += Math.abs(arr[i] - arr2[i]);
			}
		}
		System.out.println(sub);

	}
}