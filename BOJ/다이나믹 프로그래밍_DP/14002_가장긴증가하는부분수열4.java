import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 25.
 * @author Jin
 * @see https://www.acmicpc.net/problem/14002
 * @mem 12260kb
 * @time 104ms
 * @caution G4 LIS
 */

public class 14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder("");
		StringTokenizer st = null;

		int A = Integer.parseInt(br.readLine());

		int[] arr = new int[A];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int[] dp = new int[A];
		for (int i = 0; i < A; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1)
					dp[i] = dp[j]+1;
			}
			if(max < dp[i])
				max = dp[i];
		}
		//System.out.println(Arrays.toString(dp));
		output.append(max).append("\n");
		
        int value = max;
        Stack<Integer> stack = new Stack<>();

        for(int i = A-1; i >= 0; i--){
            if(value == dp[i]) {
                stack.push(arr[i]);
                value--;
            }
        }

        while (!stack.isEmpty()){
            output.append(stack.pop()).append(" ");
        }

		System.out.println(output);
	}
}
