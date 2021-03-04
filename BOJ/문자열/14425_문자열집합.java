import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/14425
* @mem 64844kb
* @time 4892ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		List<String> n = new ArrayList<>();
		List<String> m = new ArrayList<>();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			n.add(sc.next());
		}
		for (int i = 0; i < M; i++) {
			if (n.contains(sc.next()))
				cnt++;
		}
		System.out.println(cnt);
	}
}