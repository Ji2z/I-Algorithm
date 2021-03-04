import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2675
* @mem 14428kb
* @time 132ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			int r = Integer.parseInt(st.nextToken());
			String p = st.nextToken();
			for(int j=0; j<p.length(); j++) {
				for(int k=0; k<r; k++) {
					bw.write(p.charAt(j));
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}

	
}
