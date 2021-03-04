import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
* @since 2021. 2.
* @author Jin
* @see https://www.acmicpc.net/problem/1193
* @mem 16580kb
* @time 192ms
* @caution
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		int num = Integer.parseInt(br.readLine());
		int layer = 0;
		int anJ = 0;

		for (int i = 1; i <= num;layer++) {
			if (layer % 2 == 0) {
				for (int j = 0; j <= layer && i <= num; j++) {
					//System.out.printf("i(num): %d, j: %d, layer: %d\n",i,j,layer+1);
					i++;
					anJ = layer-j;
				}
			}else {
				for (int j = layer; j >= 0 && i <= num; j--) {
					//System.out.printf("i(num): %d, j: %d, layer: %d\n",i,j,layer+1);
					i++;
					anJ = layer-j;
				}
				
			}
		}

		//System.out.println(layer+", "+anJ);
		System.out.println((anJ+1)+"/"+(layer-anJ));

	}

}