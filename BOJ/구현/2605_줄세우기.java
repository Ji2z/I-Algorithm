import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 26.
* @author Jin
* @see https://www.acmicpc.net/problem/2605
* @mem 11572kb
* @time 76ms
* @caution
*/

public class 줄_세우기_2605 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			list.add(list.size()-n, i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			output.append(list.get(i)).append(" ");
		}
		
		System.out.println(output);
	}	
}
