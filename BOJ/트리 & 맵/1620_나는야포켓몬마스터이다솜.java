import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 31.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1620
 * @mem 57756kb
 * @time 488ms
 * @caution S4 map
 */

public class 1620_나는야포켓몬마스터이다솜 {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		 Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String n = Integer.toString(i+1);
			map.put(s, n);
			map.put(n, s);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			output.append(map.get(s)).append("\n");
		}
		
		System.out.println(output);
	}
	
}