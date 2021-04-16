import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 4. 16.
* @author Jin
* @see https://www.acmicpc.net/problem/2580
* @mem 15996kb
* @time 448ms
* @caution G4 2239번과 동일
*/

public class BOJ_2580_스도쿠 {

	static int[][] map;
	static boolean[] check;
	static StringBuilder output = new StringBuilder("");
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		map = new int[9][9];
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		sudoku(0);

	}

	static void sudoku(int idx) {
		if (idx >= list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					output.append(map[i][j]).append(" ");
				}
				output.append("\n");
			}
			System.out.println(output);
			System.exit(0);
		}

		int[] temp = list.get(idx);
		int i = temp[0];
		int j = temp[1];

		for (int n = 1; n < 10; n++) {
			int temp2 = map[i][j];
			if (!block(i, j, n) || !hori(i, j, n) || !verti(i, j, n))
				continue;
			map[i][j] = n;
			sudoku(idx + 1);
			map[i][j] = temp2;
		}

	}

	static boolean block(int r, int c, int number) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[(r / 3) * 3 + i][(c / 3) * 3 + j] == number)
					return false;
			}
		}
		return true;
	}

	static boolean hori(int r, int c, int number) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == number)
				return false;
		}
		return true;
	}

	static boolean verti(int r, int c, int number) {
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == number)
				return false;
		}
		return true;
	}

	static int[][] copy(int[][] map) {
		int[][] copyM = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				copyM[i][j] = map[i][j];
			}
		}
		return copyM;
	}
}
