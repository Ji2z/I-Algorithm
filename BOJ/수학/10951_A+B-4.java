import java.util.*;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/10951
* @mem 14784kb
* @time 148ms
* @caution
*/

public class Main {
	public static void main(String args[]) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		while (true) {
			try {
				String s = br.readLine();
				st = new StringTokenizer(s);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bw.write((a + b) + "\n");
			} catch (Exception e) {
				break;
			}
		}
		bw.flush();
		bw.close();

	}
}