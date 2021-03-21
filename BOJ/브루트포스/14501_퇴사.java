import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 21.
 * @author
 * @see https://www.acmicpc.net/problem/14501
 * @mem 12052kb
 * @time 88ms
 * @caution S4
 */

public class 14501_퇴사 {

	static int N, answer;
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		check(0, 0);
		
		System.out.println(answer);
	}

	static void check(int start, int sum) {
		if(start>=N) {
			answer = Math.max(sum, answer);
			return;
		}
		
		int day = list.get(start)[0];
		int pay = list.get(start)[1];
		if(start+day<=N)
			check(start+day, sum+pay);
		check(start+1,sum);
	}

}

