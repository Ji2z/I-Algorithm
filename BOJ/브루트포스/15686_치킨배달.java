package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 17.
* @author Jin
* @see https://www.acmicpc.net/problem/15686
* @mem 18344kb
* @time 256ms
* @caution
*/

public class 치킨_배달_15686 {
	
	static int N, M, answer = Integer.MAX_VALUE;
	static List<int[]> house, chicken;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) 
					house.add(new int[]{i,j});			
				else if(temp == 2) 
					chicken.add(new int[]{i,j});
			}
		}
		
		comb(M, new int[M], 0);
		
		System.out.println(answer);
	}
	
	public static void comb(int toChoose, int[] choosed, int startIdx) {
		if(toChoose == 0) {
			int sum = 0;
			for (int ho = 0; ho < house.size(); ho++) {
				int min = Integer.MAX_VALUE;
				for (int m = 0; m < M; m++) {
					int dt = Math.abs(chicken.get(choosed[m])[0]-house.get(ho)[0])+Math.abs(chicken.get(choosed[m])[1]-house.get(ho)[1]);
					min = Math.min(min, dt);
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for (int i = startIdx; i < chicken.size(); i++) {
			choosed[choosed.length-toChoose] = i;
			comb(toChoose-1, choosed, i+1);
		}	
	}
}
