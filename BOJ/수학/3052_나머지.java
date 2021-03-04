import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @since 2021. 2. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/3052
* @mem 11480kb
* @time 76ms
* @caution
*/

public class 나머지_3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			n %= 42;
			if(!list.contains(n))
				list.add(n);
		}
		
		System.out.println(list.size());
	}	
}
