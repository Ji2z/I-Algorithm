import java.io.IOException;
import java.util.Scanner;

/**
* @since 2021. 2. 5.
* @author Jin
* @see https://www.acmicpc.net/problem/11718
* @mem 18576kb
* @time 252ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		//StringTokenizer st = null;
		Scanner sc = new Scanner(System.in);
		//String s = null;
		while(sc.hasNextLine()) {
			//output.append(sc.nextLine()).append("\n");
			System.out.println(sc.nextLine());
		}
		sc.close();
		System.out.println(output);
	}

}