import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/3613
* @mem 14556kb
* @time 140ms
* @caution 많은 제한을 처리해줘야 한다.
*/

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder(str);

		if (str.contains("_")) {
			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')||str.charAt(0)=='_'||
						(i + 1 < str.length() && str.charAt(i + 1) == '_' && str.charAt(i)=='_')||
						(str.charAt(str.length()-1)=='_')) {
					System.out.println("Error!");
					return;
				}
				if (i - 1 > 0 && str.charAt(i - 1) == '_')
					sb.setCharAt(i, (char) (sb.charAt(i) - 32));
			}
			str = sb.toString().replace("_", "");
			System.out.println(str);
		} else {
			if(str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') {
				System.out.println("Error!");
			} else {
				int start = 0;
				List<String> splitList = new ArrayList<String>();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
						//System.out.println(str.charAt(i));
						sb.setCharAt(i, (char) (sb.charAt(i) + 32));
						splitList.add(sb.substring(start, i));
						//System.out.println(splitList.size());
						start = i;
					}
				}
				splitList.add(sb.substring(start, str.length()));
				sb = new StringBuilder("");
				sb.append(splitList.get(0));
				for(int i = 1; i<splitList.size(); i++) {
					sb.append('_').append(splitList.get(i));
				}
				str = sb.toString();
				System.out.println(str);
			}
		}
	}

}
