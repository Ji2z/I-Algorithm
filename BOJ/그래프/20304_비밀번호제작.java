package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 10.
* @author Jin
* @see https://www.acmicpc.net/problem/20304
* @mem 69648kb
* @time 572ms
* @caution 비트마스킹 이용
*/

public class 비밀번호제작_20304 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int[] attacks;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine()," ");
		attacks = new int[M];
		
		for(int m=0; m<M; m++) {
			attacks[m] = Integer.parseInt(tokens.nextToken());
		}
		//입력 완료
		//solution1();
		solution2();
	}
	
	private static void solution2() {
		Queue<Integer> queue = new LinkedList<>();
		// 방문 처리 - 먼저 방문한 것들이 최소 안전거리인 것들.
		boolean[] visited = new boolean[N+1];
		
		// 초기 큐 작업 : 공격한 비번들은 Queue에 넣고 방문처리(안전거리 0)
		for (int m = 0; m < M; m++) {
			queue.offer(attacks[m]);
			visited[attacks[m]] = true;
		}
		
		int depth = 0;
		while(!queue.isEmpty()) {
			// 현재 스냅샷으로 queue에 있는 것들만 돌리고 새롭게 들어온 것들은 아직 돌리면 안된다.
			int size = queue.size();
			while(size-->0) {
				// 1. 맨 앞에 있는 것 갖고오기
				int front = queue.poll();
				// 2. 필요한 작업이 있다면 한다.
				// 3. 자식 노드를 탐색해서 발견하면 queue에 추가한다.
				// 자식을 탐색하기 위해 1을 왼쪽으로 1씩 이동해가면서 비교하자.
				for (int i = 1; i <= N; i<<=1) {
					// front와 비교하면서 front에 i가 담겨있다면 빼주고, 없다면 넣어주기.
					int next;
					if((front & i) > 0) { // 이미 해당 비트를 가지고 있다면?? --> 빼주자
						//next = front & ~i;
						next = front - i;
					}else { // 해당 비트가 없기 때문에 넣어주자
						//next = front | i;
						next = front + i;
					}
					// next가 이미 사용된(더 짧은 안전거리로 세팅된)경우나 범위를 넘어가면 아웃!!
					if(next <= N && !visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
			//System.out.println(depth+" : "+queue);
			depth++;
		}
		System.out.println(--depth);
	}
	
	private static void solution1() { // 시간초과 발생
		// 우리가 구할 것은 최대 안전거리 - 최소로 초기화
		int safeRate = Integer.MIN_VALUE;
		for (int n = 0; n <= N; n++) {	// 1 000 000
			int MinSafeDist = Integer.MAX_VALUE;
			for (int m = 0; m <= M; m++) {	// 100 000
				int xor = n ^ attacks[m];
				int tempSafeDist = 0;
				//방법 1.
				//tempSafeDist = Integer.toBinaryString(xor).replaceAll("0", "").length();
				//방법 2.
				while(xor>0) {
					if((xor & 1)>0) tempSafeDist++;				
					xor >>= 1;
				}			
				MinSafeDist = Math.min(MinSafeDist, tempSafeDist);
			}
			safeRate = Math.max(safeRate, MinSafeDist);
		}
		System.out.println(safeRate);
	}
}
