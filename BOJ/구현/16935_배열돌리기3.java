package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 10.
* @author
* @see https://www.acmicpc.net/problem/16935
* @mem 56988kb
* @time 636ms
* @caution
*/

public class 배열돌리기3_16935 {
	static int N, M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		// 배열 저장
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 명령 순서 저장
		int[] rotate = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			rotate[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 0; r < rotate.length; r++) {
			N = arr.length;
			M = arr[0].length;
			switch (rotate[r]) {
			case 1:
				upAndDown();
				break;
			case 2:
				leftAndRight();
				break;
			case 3:
				turnRight();
				break;
			case 4:
				turnLeft();
				break;
			case 5:
				changeCre();
				break;
			case 6:
				chageDcre();
				break;
			default:
				break;
			}
		}
		
		// 배열 출력
		for (int[] i : arr) {
			for (int j : i) 
				output.append(j).append(" ");
			output.append("\n");
		}
		System.out.println(output);
	}

	// 1. 상하 반전
	static void upAndDown() {
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N-1-i][j];
				arr[N-1-i][j] = temp;
			}
		}
	}
	
	// 2. 좌우 반전
	static void leftAndRight() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M-1-j];
				arr[i][M-1-j] = temp;
			}
		}
	}

	// 3. 오른쪽으로 90도 회전
	static void turnRight() {
		int[][] tempArr = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempArr[j][N-1-i] = arr[i][j];
			}
		}
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = tempArr[i][j];
			}
		}
	}
	
	// 4. 왼쪽으로 90도 회전
	static void turnLeft() {
		int[][] tempArr = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempArr[M-1-j][i] = arr[i][j];
			}
		}
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = tempArr[i][j];
			}
		}
	}
	
	// 5. 1->2, 2->3, 3->4, 4->1
	static void changeCre() {
		int[][] tempArr = new int[N/2][M/2];
		// 그룹 1 임시 저장
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[i][j] = arr[i][j];
			}
		}
		// 그룹 4 -> 그룹1
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[i][j] = arr[N/2+i][j];
			}
		}
		// 그룹 3-> 그룹4
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[N/2+i][j] = arr[N/2+i][M/2+j];
			}
		}
		// 그룹2 -> 그룹3
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[N/2+i][M/2+j] = arr[i][M/2+j];
			}
		}
		// 그룹 1 임시저장 -> 그룹2
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[i][M/2+j] = tempArr[i][j];
			}
		}
	}
	
	// 6. 1->4, 4->3, 3->2, 2->1
	static void chageDcre() {
		int[][] tempArr = new int[N/2][M/2];
		// 그룹 1 임시 저장
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[i][j] = arr[i][j];
			}
		}
		// 그룹 2 -> 그룹1
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[i][j] = arr[i][M/2+j];
			}
		}
		// 그룹 3-> 그룹2
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[i][M/2+j] = arr[N/2+i][M/2+j];
			}
		}
		// 그룹4 -> 그룹3
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[N/2+i][M/2+j] = arr[N/2+i][j];
			}
		}
		// 그룹 1 임시저장 -> 그룹4
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[N/2+i][j] = tempArr[i][j];
			}
		}
	}
}
