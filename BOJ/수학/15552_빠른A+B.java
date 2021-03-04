import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/15552
* @mem 237400kb
* @time 904ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		int T = Integer.parseInt(s);

		for (int i = 0; i < T; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write((a + b)+"\n");
		}
			bw.flush();
			bw.close();
	}

}