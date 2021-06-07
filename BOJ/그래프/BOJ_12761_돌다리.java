import java.io.*;
import java.util.*;

/**
* @since 2021. 6. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/12761
* @mem 15916kb
* @time 144ms
* @caution 
*/

public class BOJ_12761_돌다리 {

	static int A, B, N, M;
	static boolean[] visited;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];
		queue = new LinkedList<>();
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		queue.add(N);
		visited[N] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int qsize = queue.size();
			for (int q = 0; q < qsize; q++) {
				int temp = queue.poll();
				
				if(temp == M) {
					return cnt;
				}
				One(true, temp);
				One(false, temp);
				Jump(true, true, temp);
				Jump(true, false, temp);
				Jump(false, true, temp);
				Jump(false, false, temp);
				LongJump(true, true, temp);
				LongJump(true, false, temp);
				LongJump(false, true, temp);
				LongJump(false, false, temp);
			}
			cnt++;
		}
		return -1;
	}
	
	static boolean isIn(int nr) {
		return 0<=nr&&nr<=100000;
	}
	
	static void One(boolean isL, int curr) {
		if(isL) {
			curr -= 1;
		}else {
			curr += 1;
		}
		if(isIn(curr) && !visited[curr]) {
			queue.add(curr);
			visited[curr] = true;
		}
	}
	
	static void Jump(boolean isL, boolean isA, int curr) {
		if(isL) {
			if(isA) {
				curr -= A;
			}else {
				curr -= B;
			}
		}else {
			if(isA) {
				curr += A;
			}else {
				curr += B;
			}
		}
		if(isIn(curr) && !visited[curr]) {
			queue.add(curr);
			visited[curr] = true;
		}
	}
	
	static void LongJump(boolean isL, boolean isA, int curr) {
		if(isL) {
			if(isA) {
				curr *= A;
			}else {
				curr *= B;
			}
		}else {
			if(isA) {
				curr *= A;
			}else {
				curr *= B;
			}
		}
		if(isIn(curr) && !visited[curr]) {
			queue.add(curr);
			visited[curr] = true;
		}
	}

}
