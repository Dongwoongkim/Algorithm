import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

	static int[][] arr = new int[6][6];
	static boolean[][] check = new boolean[6][6];
	static Map<Integer, Position> bingo = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				bingo.put(arr[i][j], new Position(i, j));
			}
		}

		int ans = 0;
		for (int i = 1; i <= 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; j++) {
				ans ++;
				int num = Integer.parseInt(st.nextToken());
				Position pos = bingo.get(num);
				check[pos.x][pos.y] = true;

				int bingoCnt = getBingoCnt();
				if (bingoCnt >= 3) {
					System.out.println(ans);
					return;
				}
			}
		}
	}

	private static int getBingoCnt() {
		int cnt = 0;

		for (int i = 1; i <= 5; i++) {
			boolean flag = false;

			if (check[i][1]) {
				flag = true;
				for (int j = 2; j <= 5; j++) {
					if (!check[i][j]) {
						flag = false;
						break;
					}
				}
			}

			if (flag) {
				cnt++;
			}
		}

		for (int i = 1; i <= 5; i++) {
			boolean flag = false;
			if (check[1][i]) {
				flag = true;
				for (int j = 2; j <= 5; j++) {
					if (!check[j][i]) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				cnt++;
			}
		}

		if (check[1][1]) {
			boolean flag = true;
			for (int i = 2; i <= 5; i++) {
				if(!check[i][i]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}

		// (1,5), (2,4), (3,3), (4,2), (5,1)
		if (check[1][5]) {
			boolean flag = true;
			for (int i = 2; i <= 5; i++) {
				if(!check[i][5 - i + 1]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}

		return cnt;
	}

	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
