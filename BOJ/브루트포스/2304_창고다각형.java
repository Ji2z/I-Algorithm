import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 21.
* @author Jin
* @see https://www.acmicpc.net/problem/2304
* @mem 12072kb
* @time 92ms
* @caution
*/

public class 창고_다각형_2304 {
	static class WareHouse implements Comparable<WareHouse>{
		int x;
		int y;
		
		public WareHouse(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(WareHouse o) {
			return Integer.compare(x, o.x);
		}	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		List<WareHouse> wh = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			wh.add(new WareHouse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(wh);
		int max = 0;
		int maxX = -1;
		for (int i = 0; i < wh.size(); i++) {
			if(max < wh.get(i).y) {
				max = wh.get(i).y;
				maxX = i;
			}
		}

		int sum = max;
		int start = wh.get(0).x;
		int h = wh.get(0).y;
		
		for (int i = 0; i <= maxX; i++) {
			if(wh.get(i).y >= h) {
				sum += ((wh.get(i).x-start)*h);
				h = wh.get(i).y;
				start = wh.get(i).x;
			}	
		}
		
		start = wh.get(wh.size()-1).x;
		h = wh.get(wh.size()-1).y;
		
		for (int i = wh.size()-1; i >= maxX; i--) {
			if(wh.get(i).y >= h) {
				sum += ((start-wh.get(i).x)*h);
				h = wh.get(i).y;
				start = wh.get(i).x;
			}	
		}
			
		System.out.println(sum);
	}	
}
