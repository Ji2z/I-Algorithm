import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2742
* @mem 21828kb
* @time 304ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = null;

		String s = br.readLine();
		int T = Integer.parseInt(s);

		for (int i = T; i > 0; i--) {
			bw.write(i+"\n");
		}
			bw.flush();
			bw.close();
	}

}