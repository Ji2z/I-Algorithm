import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/7568
* @mem 16732kb
* @time 164ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		int[][] data = new int[T][2];
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] rank = new int[T];
		for(int i=0; i<T; i++) {
			rank[i]++;
			for(int j=0; j<T; j++) {
				if(i!=j) {
					if(data[i][0]<data[j][0] && data[i][1]<data[j][1])
						rank[i]++;
				}
			}
		}
		
		for(int i: rank) {
			System.out.printf(i+" ");
		}
	}
}
