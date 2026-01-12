import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		for (int i = 2; i <= m - 1; i++) {
			int curH = arr[i];

			int right = -1;
			int left = -1;

			// 좌측 벽중 가장 높은 벽
			int leftHighest = curH;
			for (int j = 1; j <= i - 1; j++) {
				if (leftHighest < arr[j]) {
					left = j;
					leftHighest = arr[j];
				}
			}

			// 우측 벽중 가장 높은 벽
			int rightHighest = curH;
			for (int j = i + 1; j <= m; j++) {
				if (rightHighest < arr[j]) {
					right = j;
					rightHighest = arr[j];
				}
			}

			// 양 옆에 현재 블록보다 높은 블록이 있는 경우
			if(left != -1 && right != -1) {
				int w = Math.min(arr[left], arr[right]);
				ans += (w - curH);
			}
		}

		System.out.println(ans);
	}
}
