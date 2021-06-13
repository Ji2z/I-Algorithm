import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 13.
* @author Jin
* @see https://www.acmicpc.net/problem/18870
* @mem 364288kb
* @time 2524ms
* @caution S2
*/

public class BOJ_18870_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			list.add(a);
			if(!map.containsKey(a)) {
				queue.add(a);
				map.put(a, 0);
			}
		}
		
		int idx = 0;
		while(!queue.isEmpty()) {
			map.replace(queue.poll(),idx++);
		}
		
		for (int i = 0; i < list.size(); i++) {
			output.append(map.get(list.get(i))).append(" ");
		}

		System.out.println(output);
	}

}
