import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int t, n, m, w;
	static long[] dp;
	static List<Edge> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		for (int c = 0; c < t; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			dp = new long[n + 1];
			edges = new ArrayList<>();

			for (int i = 0; i <= n; i++) {
				dp[i] = Long.MAX_VALUE;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				edges.add(new Edge(start, end, time));
				edges.add(new Edge(end, start, time));
			}

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				edges.add(new Edge(start, end, -time));
			}

			if(bf(1)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean bf(int start) {
		dp = new long[n + 1];
		dp[start] = 0;

		// 정점 사이의 최단 경로 = 최대 V−1
		// 갱신이 일어나지 않은경우 조기종료
		// start에서 end로 가는 weight를 최대 v-1번 갱신하여 시작노드로부터 최소비용을 계산
		for (int i = 0; i < n - 1; i++) {
			boolean changed = false;
			for (Edge edge : edges) {
				if (dp[edge.start] != Long.MAX_VALUE && dp[edge.start] + edge.time < dp[edge.end]) {
					dp[edge.end] = dp[edge.start] + edge.time;
					changed = true;
				}
			}

			if (!changed) break;
		}

		// v-1번 갱신한 이후 한번 더 갱신했을 때
		// 음수 가중치로 갱신이 발생하면 음수사이클
		for (Edge edge : edges) {
			if (dp[edge.start] != Long.MAX_VALUE && dp[edge.start] + edge.time < dp[edge.end]) {
				return true;
			}
		}

		return false;
	}

	static class Edge {
		int start;
		int end;
		int time;

		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
}
