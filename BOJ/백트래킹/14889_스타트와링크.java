import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/14889
* @mem 56056kb
* @time 580ms
* @caution
*/

public class 14889_스타트와링크 {
	
	static int[][] team;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(N/2, new boolean[N], 0);
		
		System.out.println(min);
	}
	
	static int cnt = 0;
	static int min = Integer.MAX_VALUE;
	static void comb(int toChoose, boolean[] choosed, int startIdx) {
		if(cnt==(1<<N-1)) return;
		if(toChoose == 0) {
			cnt++;
			List<Integer> start = new ArrayList<>();
			List<Integer> link = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(choosed[i]) {
					start.add(i);
				}else
					link.add(i);
			}
			sum = 0;
			power(2, new int[2], 0, start);
			int startPower = sum;
			sum = 0;
			power(2, new int[2], 0, link);
			int linkPower = sum;
			
			min = Math.min(min, Math.abs(startPower-linkPower));
			return;
		}
		
		for (int i = startIdx; i < N; i++) {
			choosed[i] = true;
			comb(toChoose-1, choosed, i+1);
			choosed[i] = false;
		}
	}
	
	static int sum = 0;
	static void power(int toChoose, int[] choosed, int startIdx, List<Integer> list) {
		if(toChoose == 0) {
			sum += team[choosed[0]][choosed[1]];
			sum += team[choosed[1]][choosed[0]];
			return;
		}
		for (int i = startIdx; i < N/2; i++) {
			choosed[2-toChoose] = list.get(i);
			power(toChoose-1, choosed, i+1, list);
		}
	}
}
