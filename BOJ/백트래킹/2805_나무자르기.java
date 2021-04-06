import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 6.
* @author Jin
* @see https://www.acmicpc.net/problem/2805
* @mem 167792kb
* @time 488ms
* @caution S3 저장 범위 잘 보기
*/

public class 2805_나무자르기 {

	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		int left = 0;
		int right = 2000000000;
		while(left<=right) {
			int mid = (left+right)/2;
			long sum = 0;
			for (int i = 0; i < tree.length; i++) {
				long temp = tree[i] - mid;
				temp = temp>0?temp:0;
				sum += temp;
			}
			if(sum >= M) {
				answer = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
			
		System.out.println(answer);
	}

}