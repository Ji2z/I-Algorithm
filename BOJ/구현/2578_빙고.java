import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 5.
* @author Jin
* @see https://www.acmicpc.net/problem/2578
* @mem 13012kb
* @time 104ms
* @caution bingo==3이 아닌 bingo>=3이라고 해주어야 한다.
*/

public class 2578_빙고 {
	
	static boolean[][] pan;
	static int bingo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		bingo = 0;
		pan = new boolean[5][5];
		
		List<Integer> diaL = new ArrayList<>();
		List<Integer> diaR = new ArrayList<>();
		
		int[][] numberIdx = new int[26][2];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				numberIdx[num][0] = i;
				numberIdx[num][1] = j;
				if(i==j) 
					diaL.add(num);
				if(i+j==4)
					diaR.add(num);
			}
		}
		
		boolean L = false;
		boolean R = false;
		int cnt = 0;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				int num = Integer.parseInt(st.nextToken());
				int nI = numberIdx[num][0];
				int nJ = numberIdx[num][1];
				pan[nI][nJ] = true;
				hori(nI);
				verti(nJ);
				if(!L && nI==nJ) {
					if(diaL.contains(num)) {
						diaL.remove(diaL.indexOf(num));
						if(diaL.size() == 0) {
							bingo++;
							L = true;
						}
					}
				}
				if(!R && nI+nJ==4) {
					if(diaR.contains(num)) {
						diaR.remove(diaR.indexOf(num));
						if(diaR.size() == 0) {
							bingo++;
							R = true;
						}
					}
				}
				if(bingo >= 3) {
					System.out.println(cnt);
					System.exit(0);
				}
			} // num 받아오기
		}
			
	}	
	
	static void hori(int row) {
		for (int i = 0; i < 5; i++) {
			if(!pan[row][i])
				break;
			if(i+1 == 5) {
				bingo++;
			}
		}
	}
	
	static void verti(int col) {
		for (int i = 0; i < 5; i++) {
			if(!pan[i][col])
				break;
			if(i+1 == 5) {
				bingo++;
			}
		}
	}
	
	
}