import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/14867
* @mem 343600kb
* @time 1932ms
* @caution 방문 체크를 이중배열로 하면 heap 메모리 모자라서 해쉬맵으로 해결 - 근데 시간이 너무 많이 걸린다.
*/

public class BOJ_14867_물통2 {

	static int A, B, C, D;
	//static boolean[][] visited;
	static Map<String, Boolean> visited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		//visited = new boolean[A+1][B+1];
		visited = new HashMap<>();
		queue = new LinkedList<>();
		
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		queue.add(new int[] {0, 0});
		visited.put("0-0", true);
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			for (int q = 0; q < qsize; q++) {
				int[] temp = queue.poll();
				
				if(temp[0] == C && temp[1] == D) {
					return cnt;
				}
				
				Fill(true, temp[0], temp[1]);
				Fill(false, temp[0], temp[1]);
				Empty(true, temp[0], temp[1]);
				Empty(false, temp[0], temp[1]);
				Move(true, temp[0], temp[1]);
				Move(false, temp[0], temp[1]);
				
			}
			cnt++;
		}
		return -1;
	}
	
	static boolean isIn(int nr, int nc) {
		return 0<=nr&&nr<100000&&0<=nc&&nc<=100000;
	}
	
	static void Fill(boolean isA, int currA, int currB) {
		if(isA) {
			currA = A;
		}else {
			currB = B;
		}
		String s = Integer.toString(currA)+"-"+Integer.toString(currB);
		if(isIn(currA, currB) && !visited.containsKey(s)) {
			queue.add(new int[] {currA, currB});
			visited.put(s, true);
		}
	}
	
	static void Empty(boolean isA, int currA, int currB) {
		if(isA) {
			currA = 0;
		}else {
			currB = 0;
		}
		String s = Integer.toString(currA)+"-"+Integer.toString(currB);
		if(isIn(currA, currB) && !visited.containsKey(s)) {
			queue.add(new int[] {currA, currB});
			visited.put(s, true);
		}
	}
	
	static void Move(boolean isAtoB, int currA, int currB) {
		if(isAtoB) {
			if(currA == 0) return;
			int temp = B - currB;
			if(temp == 0) return;
			if(currA > temp) { // a에 들은게 더 많다.
				currA -= temp;
				currB = B;
			}else {
				currB += currA;
				currA = 0;
			}
		}else {
			if(currB == 0) return;
			int temp = A - currA;
			if(temp == 0) return;
			if(currB > temp) { // b에 들은게 더 많다.
				currB -= temp;
				currA = A;
			}else {
				currA += currB;
				currB = 0;
			}
		}
		String s = Integer.toString(currA)+"-"+Integer.toString(currB);
		if(isIn(currA, currB) && !visited.containsKey(s)) {
			queue.add(new int[] {currA, currB});
			visited.put(s, true);
		}
	}

}
