import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/10871
* @mem 17272kb
* @time 208ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s);
		int T = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		s = br.readLine();
		st = new StringTokenizer(s);
		for (int i = 0; i < T; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a<x)
				bw.write(a+" ");
		}
			bw.flush();
			bw.close();
	}

}
