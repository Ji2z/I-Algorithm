import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/11720
* @mem 16324kb
* @time 152ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		String s = br.readLine();
		for(int i=0; i<num; i++) {
			sum += Integer.parseInt(s.charAt(i)+"");
		}
		System.out.println(sum);
		
	}

	
}