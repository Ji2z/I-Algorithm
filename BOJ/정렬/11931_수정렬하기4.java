import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/11931
 * @mem 215052kb
 * @time 1380ms
 * @caution S5
 */

public class 11931_수정렬하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}	

		Collections.sort(list);
		for (int i = list.size()-1; i >= 0; i--) {
			output.append(list.get(i)).append("\n");
		}
		
		System.out.println(output);
	}
}