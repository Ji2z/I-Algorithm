import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/13300
* @mem 21656kb
* @time 308ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int max = sc.nextInt();

		int[] girl = new int[6];
		int[] boy = new int[6];

		for (int i = 0; i < num; i++) {
			int gen = sc.nextInt();
			int grade = sc.nextInt();

			if (gen == 0) {
				girl[grade - 1]++;
			} else {
				boy[grade - 1]++;
			}
		}

		int room = 0;
		for (int i = 0; i < 6; i++) {
			if (girl[i] != 0) {
				if (girl[i] % max != 0) {
					room += 1;
				}
				room += (girl[i] / max);
			}
			if (boy[i] != 0) {
				if (boy[i] % max != 0) {
					room += 1;
				}
				room += (boy[i] / max);
			}
		}

		System.out.println(room);

	}
}