import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/2231
* @mem 207056kb
* @time 428ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String sNum = br.readLine();
		int num = Integer.parseInt(sNum);
		int min = 0;
		int answer = 0;
		
		for( ; min<num; min++) {
			int check = 0;
			String sMin = Integer.toString(min);
			check += min;
			for(int j=0; j<sMin.length();j++) {
				check += Integer.parseInt(sMin.charAt(j)+"");
			}
			if(check==num) {
				answer = min;
				break;
			}
		}
		
		System.out.println(answer);
	}
}