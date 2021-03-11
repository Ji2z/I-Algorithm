import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 11.
 * @author Jin
 * @see https://www.acmicpc.net/problem/1966
 * @mem 12296kb
 * @time 112ms
 * @caution 
 */

public class 1966_프린터큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			Deque<Integer> que = new ArrayDeque<>(); // 프린터에 예약된 순서 저장하려고..
			Deque<Boolean> bool = new ArrayDeque<>(); // 내가 관심있는 문서 저장하려고..
			List<Integer> imt = new ArrayList<>(); // 중요도를 정렬된 순으로 저장하려고..
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < n; j++) {
				que.offer(Integer.parseInt(st.nextToken()));
				imt.add(que.peekLast());
				if(j==idx)
					bool.offer(true);
				else bool.offer(false);
			}
			
			Collections.sort(imt); // 오름차순 정렬, 내림차순으로 할 수 있지만 귀찮다. 뒤부터 보자..
			while(true) { 
				if(que.peek()<imt.get(imt.size()-1)) { // 현재 이것보다 더 중요한 문서가 있다면..!!
					que.offer(que.poll());
					bool.offer(bool.poll());
				}else {
					cnt++;
					que.poll();
					boolean what = bool.poll();
					imt.remove(imt.size()-1);
					if(what) {
						output.append(cnt).append("\n");
						break;
					}
				}
			}		
		}
		
		System.out.println(output);
	}
}