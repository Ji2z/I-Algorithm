import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @since 2021. 3. 10.
 * @author Jin
 * @see https://www.acmicpc.net/problem/6198
 * @mem 23040kb
 * @time 280ms
 * @caution 자료형 크기와 부등호 조건 자세히 보기..
 */

public class 6198_옥상정원꾸미기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<Long> building = new Stack<>();
		
		long answer = 0;
		for (int i = 0; i < N; i++) {
			long n = Integer.parseInt(br.readLine());
			if(!building.isEmpty()) {			
				if(building.peek()>n) {
					answer += building.size();
				}else {
					while(!building.isEmpty() && building.peek()<=n) {
						building.pop();
					}
					answer += building.size();
				}
			}
			building.push(n);
		}		
		System.out.println(answer);
	}
}