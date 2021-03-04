import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021. 2. 7.
 * @author
 * @see https://www.acmicpc.net/problem/2447
 * @mem 54024kb
 * @time 480ms
 * @caution
 */

public class 2447_별찍기{

	static int N;
	static char[][] map;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = '*';
			}
		}
		
		star(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				output.append(map[i][j]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	static void star(int n, int startI, int startJ) {
		if(n==0) {	
			return;
		}
		
		for (int i = startI+n/3; i < startI+n/3*2; i++) {
			for (int j = startJ+n/3; j < startJ+n/3*2; j++) {
				map[i][j] = ' ';
			}
		}
		
		star(n/3, startI, startJ);
		star(n/3, startI, startJ+n/3);
		star(n/3, startI, startJ+n/3*2);
		star(n/3, startI+n/3, startJ);
		star(n/3, startI+n/3, startJ+n/3*2);
		star(n/3, startI+n/3*2, startJ);
		star(n/3, startI+n/3*2, startJ+n/3);
		star(n/3, startI+n/3*2, startJ+n/3*2);
	}

}

