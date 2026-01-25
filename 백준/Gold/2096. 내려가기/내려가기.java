import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] arr;
	static int[][] maxDp;
	static int[][] minDp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1][3];
		maxDp = new int[n + 1][3];
		minDp = new int[n + 1][3];

		for (int j = 0; j < n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			maxDp[0][i] = arr[0][i];
			minDp[0][i] = arr[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					maxDp[i][j] = arr[i][j] + Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]);
					minDp[i][j] = arr[i][j] + Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]);
				}
				if (j == 1) {
					maxDp[i][j] = arr[i][j] + Math.max(maxDp[i - 1][j], Math.max(maxDp[i - 1][j - 1], maxDp[i - 1][j + 1]));
					minDp[i][j] = arr[i][j] + Math.min(minDp[i - 1][j], Math.min(minDp[i - 1][j - 1], minDp[i - 1][j + 1]));
				}
				if (j == 2) {
					maxDp[i][j] = arr[i][j] + Math.max(maxDp[i - 1][j], maxDp[i - 1][j - 1]);
					minDp[i][j] = arr[i][j] + Math.min(minDp[i - 1][j], minDp[i - 1][j - 1]);
				}
			}
		}

		int max = -1;
		int min = n * 9;
		for (int i = 0; i < 3; i++) {
			max = Math.max(maxDp[n - 1][i], max);
			min = Math.min(minDp[n - 1][i], min);
		}

		System.out.print(max + " " + min);
	}
}
