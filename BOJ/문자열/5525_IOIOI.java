import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/5525
* @mem 52288kb
* @time 608ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int len = sc.nextInt();
		String s = sc.next();

		int pLen = 1 + 2 * N;
		int cnt = 0;
		int subcnt = 1;
		for (int i = 0; i <= len - pLen; i++) {
			if (s.charAt(i) == 'I') {
				for (int j = 1; j < len - i; j += 2) {
					if (i + j + 1 < len && s.substring(i + j, i + j + 2).equals("OI")) {
						subcnt += 2;
					} else {
						i += (j - 1);
						break;
					}
					;
				}
			}
			if (subcnt >= pLen) {
				cnt = cnt + ((subcnt - pLen) / 2 + 1);
			}
			subcnt = 1;
		}

		System.out.println(cnt);
	}
}