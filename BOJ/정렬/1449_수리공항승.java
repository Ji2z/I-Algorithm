import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 28.
* @author Jin
* @see https://www.acmicpc.net/problem/1449
* @mem 11604kb
* @time 80ms
* @caution
*/

public class 수리공_항승_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] water = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		float tape = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			water[i] = Integer.parseInt(st.nextToken());;
		}
		Arrays.sort(water);
		for (int i = 0; i < N; i++) {
			if(water[i]+0.5 > tape) {
				cnt++;
				tape = (float) (water[i]-0.5+L);
			}
		}
		System.out.println(cnt);
		
	}
}
