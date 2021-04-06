import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 6.
* @author Jin
* @see https://www.acmicpc.net/problem/1654
* @mem 15156kb
* @time 136ms
* @caution S3 저장 범위 잘 보기
*/

public class 1654_랜선자르기 {

	static int K, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[] lan = new int[K];
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
		}
		
		long answer = 0;
		long left = 1;
		long right = (long) (Math.pow(2, 31))-1;
		while(left<=right) {
			long mid = (left+right)/2;
			long sum = 0;
			for (int i = 0; i < lan.length; i++) {
				long temp = lan[i]/mid;
				sum += temp;
			}
			if(sum >= N) {
				answer = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
			
		System.out.println(answer);
	}

}