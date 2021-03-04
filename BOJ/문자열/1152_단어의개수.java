import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/1152
* @mem 27560kb
* @time 296ms
* @caution
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] list = str.split(" ");
		int space = 0;
		if(list.length>0 && list[0].equals("")) space++;
		if(list.length>1 && list[list.length-1].equals("")) space++;
		
		System.out.println(list.length-space);

	}

}
