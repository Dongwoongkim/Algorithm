import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int team = 0;

        // 만들 수 있는 팀 최대한으로 만들고
        while (true) {
            if (w - 2 < 0 || m - 1 < 0) {
                break;
            }

            w -= 2;
            m -= 1;
            team++;
        }

        // 팀을 결성하고 난 후, 남은 인원에서 인턴십에 나갈 사람이 부족하다면
        // 팀을 해체하고 인턴십에 보낸다.
        while (true) {
            if (w + m >= k) {
                break;
            }

            team--;
            w += 2;
            m += 1;
        }

        System.out.println(team);
    }
}
