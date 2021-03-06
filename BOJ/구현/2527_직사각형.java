import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 3. 7.
* @author Jin
* @see https://www.acmicpc.net/problem/2527
* @mem 11576kb
* @time 80ms
* @caution
*/

public class 2527_직사각형 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;
		
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int ap = Integer.parseInt(st.nextToken());
			int aq = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			int bp = Integer.parseInt(st.nextToken());
			int bq = Integer.parseInt(st.nextToken());
			
			if(ap<bx||bp<ax||aq<by||bq<ay) {
				output.append("d\n");
				continue;
			}else if(ax==bp){
				if((ay==bq)||(aq==by)) {
					output.append("c\n");
					continue;
				}else {
					output.append("b\n");
					continue;
				}
			}else if(ap==bx){
				if((ay==bq)||(aq==by)) {
					output.append("c\n");
					continue;
				}else {
					output.append("b\n");
					continue;
				}
			}else if((ay==bq)||(aq==by)){
				output.append("b\n");
				continue;			
			}else {
				output.append("a\n");
			}
		}
		
		System.out.println(output);
	}
}