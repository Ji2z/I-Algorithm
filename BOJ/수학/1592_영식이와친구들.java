import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 25.
* @author Jin
* @see https://www.acmicpc.net/problem/1592
* @mem 11516kb
* @time 92ms
* @caution
*/

public class 영식이와_친구들_1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 공 받는 횟수 제한
		int L = Integer.parseInt(st.nextToken()); // 공 던지는 크기
		
		int[] ball = new int[N];
		
		ball[0] = 0;
		int idx = 0;
		int cnt = -1;
		
		while(true) {
			ball[idx]++;
			cnt++;
			if(ball[idx]==M)
				break;
			if(ball[idx] % 2 == 1) {
				idx += L;
				if(idx > N-1)
					idx %= N;
			}else {
				idx -= L;
				if(idx<0)
					idx += N;
			}
		}
		
		System.out.println(cnt);
	}	
}
