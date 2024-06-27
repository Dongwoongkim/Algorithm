import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ans = 0;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = new int[12];

        for (int i = 1; i <= 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0, 0, 0);
        System.out.println(ans);

    }

    private static void dfs(int cur, int score, int previous_pick, int cnt) {
        if (cur == 11) {
            if (score >= 5) {
                ans++;
            }
            return;
        }

        for (int currentPick = 1; currentPick <= 5; currentPick++) {
            int curCnt;

            if (previous_pick == currentPick) {
                curCnt = cnt + 1;
            } else {
                curCnt = 1;
            }

            if (curCnt == 3) {
                continue;
            }

            if (answer[cur] == currentPick) {
                dfs(cur + 1, score + 1, currentPick, curCnt);
            } else {
                dfs(cur + 1, score, currentPick, curCnt);
            }
        }
    }
}
