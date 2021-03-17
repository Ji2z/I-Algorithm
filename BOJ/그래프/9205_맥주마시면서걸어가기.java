import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 17.
 * @author Jin
 * @see https://www.acmicpc.net/problem/9205
 * @mem 13592kb
 * @time 128ms
 * @caution S1
 */

public class 9205_맥주마시면서걸어가기 {

	static int T, N, M;
	static List<Place> place;
	static boolean possible;

	static class Place{
		int x;
		int y;
		int[] dist;
		
		public Place(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			dist = new int[N+2];
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			place = new ArrayList<>();
			possible = false;
			
			//집
			st = new StringTokenizer(br.readLine()," ");
			int housei = Integer.parseInt(st.nextToken());
			int housej = Integer.parseInt(st.nextToken());
			Place house = new Place(housei, housej); 
			
			place.add(house);
			//편의점
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				place.add(new Place(x,y));
			}
			//페스티벌
			st = new StringTokenizer(br.readLine()," ");
			int festi = Integer.parseInt(st.nextToken());
			int festj = Integer.parseInt(st.nextToken());
			Place fest = new Place(festi, festj); 
			place.add(fest);
			
			for (int i = 0; i < place.size(); i++) {
				for (int j = 0; j < place.size(); j++) {
					Place p1 = place.get(i);
					Place p2 = place.get(j);					
					int distance = Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
					p1.dist[j] = distance;
				}
			}
			
			check(0, 20, new boolean[N+2]);
			
			if(possible)
				output.append("happy\n");
			else
				output.append("sad\n");
		}	

		System.out.println(output);
	}
	
	static void check(int idx, int beer, boolean[] visited) {
		if(idx == N+1) {
			possible = true;
			return;
		}
		visited[idx] = true;
		Place curr = place.get(idx);
		for (int i = 0; i < N+2; i++) {
			int cnt = curr.dist[i]%50==0?curr.dist[i]/50:curr.dist[i]/50+1;
			if(!visited[i] && cnt<=20) {
				check(i, 20, visited);
			}
		}
	}
}