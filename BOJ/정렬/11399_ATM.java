import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/**
* @since 2021. 2. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/11399
* @mem 11904kb
* @time 88ms
* @caution
*/

public class ATM_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		List<Integer> time = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			time.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(time);
		
		int minTime = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += time.get(i);
			minTime += sum;
		}
		
		System.out.println(minTime);
	}	
}
