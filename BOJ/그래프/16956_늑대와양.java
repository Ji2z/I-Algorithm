import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 3.
* @author Jin
* @see https://www.acmicpc.net/problem/16956
* @mem 19264kb
* @time 180ms
* @caution
*/

public class 늑대와_양_16956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		boolean flag = false;
		sheep:for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 양이라면
				if(map[i][j] == 'S') {
					//상
					if(i-1>=0 && map[i-1][j] == '.')
						map[i-1][j] = 'D';
					else if(i-1>=0 && map[i-1][j] == 'W') {
						flag = true;
						break sheep;
					}	
					//하
					if(i+1<R && map[i+1][j] == '.')
						map[i+1][j] = 'D';
					else if(i+1<R && map[i+1][j] == 'W') {
						flag = true;
						break sheep;
					}
					//좌
					if(j-1>=0 && map[i][j-1] == '.')
						map[i][j-1] = 'D';
					else if(j-1>=0 && map[i][j-1] == 'W') {
						flag = true;
						break sheep;
					}
					//우
					if(j+1<C && map[i][j+1] == '.')
						map[i][j+1] = 'D';
					else if(j+1<C && map[i][j+1] == 'W') {
						flag = true;
						break sheep;
					}
				}
			}	
		}//sheep for
		
		if(flag)
			System.out.println(0);
		else {
			output.append(1).append("\n");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					output.append(map[i][j]);
				}
				output.append("\n");
			}
			System.out.println(output);
		}	
	}
}
