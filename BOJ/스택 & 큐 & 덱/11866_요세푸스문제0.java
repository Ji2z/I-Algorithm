import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/11866
* @mem 14448kb
* @time 136ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken())-1;

		List<Integer> list = new ArrayList<>();
		for (int n = 1; n <= N; n++) {
			list.add(n);
		}

		int idx = K;
		output.append("<");		
		while(list.size()>1) {
			output.append(list.get(idx)).append(", ");
			list.remove(idx);
			idx += K;
			idx %= list.size();
		}
		output.append(list.get(0)).append(">");
		System.out.println(output);
	}

}