import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 22.
* @author Jin
* @see https://www.acmicpc.net/problem/10158
* @mem 11564kb
* @time 80ms
* @caution 시간초과가 많이 뜬다. 0.15초 제한. JAVA11은 아예 안된다.... JAVA8로 됨.
*/

public class 개미_10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder output = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		int time = sc.nextInt();
		
		x = (x+time) % (2*N);
		y = (y+time) % (2*M);
		
		x = (N-Math.abs(x-N));
		y = (M-Math.abs(y-M));
		
		System.out.println(x+" "+y);
		
		
//		x += time;
//		y += time;
//		
//		x %= (2*N);
//		y %= (2*M);
		
		
		
		// 0 1 2 3 4 5 6 7 8 9 10 11 12
		
//		if(x/N%2 == 0) 
//			x %= N;
//		else
//			x = N-x%N;
//		
//		if(y/M%2 == 0) 
//			y %= M;
//		else
//			y = M-y%M;
	}	
}
