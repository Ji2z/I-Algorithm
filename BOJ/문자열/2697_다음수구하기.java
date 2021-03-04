import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2697
* @mem 18152kb
* @time 232ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			String num = sc.next();
			char[] arr = num.toCharArray();
			int index = -1;
			int index2 = -1;
			for (int i = 0; i < arr.length; i++) {
				if (arr.length - 1 - i == index) {
					// System.out.println("t: " + t + ", index: " + index + ", index2: " + index2);
					char c = arr[index];
					arr[index] = arr[index2];
					arr[index2] = c;
					// System.out.println(1);
					// System.out.println(Arrays.toString(arr));
					break;
				}
				for (int j = 1; j < arr.length - 1 - i; j++) {
					if (arr[arr.length - 1 - i] > arr[arr.length - 1 - i - j]) {
						if (index < arr.length - 1 - i - j) {
							index = arr.length - 1 - i - j;
							index2 = arr.length - 1 - i;
							// System.out.println(2);
						}
						// System.out.println(3);
						break;
					}
				}
			}
			if (index == -1) {
				System.out.println("BIGGEST");
			} else {
				String numA = String.valueOf(arr).substring(0, index + 1);
				char[] numB = String.valueOf(arr).substring(index + 1).toCharArray();
				// System.out.println(Arrays.toString(arr));
				int[] ten = new int[10];
				// System.out.println((int)numB[0]);
				// System.out.println(ten[(int)numB[0]]);
				for (int i = 0; i < numB.length; i++) {
					// System.out.println("i: "+i+", "+numB[i]);
					ten[Character.getNumericValue(numB[i])]++;
				}
				String s = "";
				for (int i = 0; i < 10; i++) {
					if (ten[i] > 0) {
						for (int j = 0; j < ten[i]; j++) {
							s = s.concat(Integer.toString(i));
						}
					}
				}

				// System.out.println(numA);
				// System.out.println(s);
				System.out.println(numA + s);
			}
		}
	}
}