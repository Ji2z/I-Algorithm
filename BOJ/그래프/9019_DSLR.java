import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 22.
 * @author Jin
 * @see https://www.acmicpc.net/problem/9019
 * @mem 317220kb
 * @time 3576ms
 * @caution G5 문자열로 풀면 시간초과, bfs
 */

public class 9019_DSLR {

	static int T, first, last;
	static StringBuilder output;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			visited = new boolean[10000];
			st = new StringTokenizer(br.readLine(), " ");
			first = Integer.parseInt(st.nextToken());
			last = Integer.parseInt(st.nextToken());
			
			Queue<Integer> queue = new LinkedList<>();
			Queue<String> commend = new LinkedList<>();
			queue.offer(first);
			commend.offer("");
			while(!queue.isEmpty()) {
				int s = queue.poll();
				String sc = commend.poll();
				int temp;
				temp = L(s);
				if(temp == last) {
					output.append(sc).append("L\n");
					break;
				}else if(!visited[temp]){
					visited[temp] = true;
					queue.offer(temp);
					commend.offer(sc+"L");
				}
				temp = R(s);
				if(temp == last) {
					output.append(sc).append("R\n");
					break;
				}else if(!visited[temp]){
					visited[temp] = true;
					queue.offer(temp);
					commend.offer(sc+"R");
				}
				
				temp = D(s);
				if(temp == last) {
					output.append(sc).append("D\n");
					break;
				}else if(!visited[temp]){
					visited[temp] = true;
					queue.offer(temp);
					commend.offer(sc+"D");
				}
				
				temp = S(s);
				if(temp == last) {
					output.append(sc).append("S\n");
					break;
				}else if(!visited[temp]){
					visited[temp] = true;
					queue.offer(temp);
					commend.offer(sc+"S");
				}
			}
		}
	
		System.out.println(output);
	}
	
	static int L(int num) {
		int temp = ((num%1000)/100)*1000+((num%100)/10)*100+(num%10)*10+(num/1000);
		//System.out.println("L"+num);
		return temp;
	}
	
	static int R(int num) {
		int temp = (num%10)*1000+(num/1000)*100+((num%1000)/100)*10+((num%100)/10);
		//System.out.println("R"+num);
		return temp;
	}
	
	static int D(int num) {
		num *= 2;
		if(num>9999)
			num %= 10000;
		//System.out.println("D"+num);
		return num;
	}
	
	static int S(int num) {
		if(num == 0)
			num = 9999;
		else
			num -= 1;
		//System.out.println("S"+num);
		return num;
	}
}