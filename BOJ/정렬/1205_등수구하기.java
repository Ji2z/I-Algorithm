import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 28.
* @author Jin
* @see https://www.acmicpc.net/problem/1205
* @mem 11568kb
* @time 80ms
* @caution
*/

public class 등수_구하기_1205 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int Score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		int rank = 1;
		int cnt = 0;
		if(N!=0)
			st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++,rank++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>Score) {
				list.add(num);			
			}else if(num == Score) {
				cnt++;
				list.add(num);
			}
			else break;
			
		}
		
		list.add(Score);
		
		if(cnt != 0) 
			rank -= cnt;
			
		if(list.size() > P) System.out.println("-1");
		else if(rank == 0) System.out.println("1");
		else System.out.println(rank);
	}
}
