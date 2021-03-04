import java.io.IOException;
import java.util.Scanner;

/**
 * @since 2021. 2. 5.
 * @author Jin
 * @see https://www.acmicpc.net/problem/11719
 * @mem 18628kb
 * @time 244ms
 * @caution
 */

public class Main {

	public static void main(String[] args) throws IOException {

		StringBuilder output = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
		System.out.println(output);
	}

}