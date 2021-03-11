import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1181
 * @mem 29220kb
 * @time 1532ms
 * @caution S5
 */

public class 1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if(!list.contains(s))
				list.add(s);
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int diff = Integer.compare(o1.length(), o2.length());
				return diff!=0?diff:o1.compareTo(o2);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			output.append(list.get(i)).append("\n");
		}
		
		System.out.println(output);
	}
}