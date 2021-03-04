import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 23.
* @author Jin
* @see https://www.acmicpc.net/problem/2116
* @mem 23324kb
* @time 220ms
* @caution
*/

public class 주사위_쌓기_2116 {

	static int[] pair = {5,3,4,1,2,0};
	static List<int[]> dice;
	static int N;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		dice = new ArrayList<>();
		// 0 1 2 3 4 5 // A B C D E F // F D E B C A
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dice.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		for (int i = 1; i <= 6; i++) {
			getMax(0, i, 0);		
		}
		
		System.out.println(result);
	}	
	
	static void getMax(int index, int num, int sum) {
		if(index == N) {
			result = Math.max(result, sum);
			return;
		}
		int maxN = Integer.MIN_VALUE;
		boolean[] select = new boolean[6];
		int pairN = -1;
		for (int i = 0; i < 6; i++) {
			if(dice.get(index)[i]==num) {
				select[i] = true;
				select[pair[i]] = true;
				pairN = dice.get(index)[pair[i]];
			}
		}
		for (int i = 0; i < 6; i++) {
			if(!select[i])
				maxN = Math.max(maxN,dice.get(index)[i]);
		}
		getMax(index+1, pairN, sum+maxN);
	}
}
