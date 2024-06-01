import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] notFirstOn = new char[100_001];
    static char[] firstOn = new char[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String answer = br.readLine();

        for (int i = 0; i < n; i++) {
            firstOn[i] = line.charAt(i);
            notFirstOn[i] = line.charAt(i);
        }

        // 첫번째 스위치 안 누른 경우
        int cnt = 0;
        for (int i = 1; i <= n - 2; i++) {
            if (notFirstOn[i - 1] != answer.charAt(i - 1)) {
                for (int j = i - 1; j <= i + 1; j++) {
                    if (notFirstOn[j] == '1') {
                        notFirstOn[j] = '0';
                    } else if (notFirstOn[j] == '0') {
                        notFirstOn[j] = '1';
                    }
                }
                cnt++;
            }
        }

        if (notFirstOn[n - 1] != answer.charAt(n - 1)) {
            cnt++;
            char k = notFirstOn[n - 1];
            if (k == '0') {
                notFirstOn[n - 1] = '1';
                if (notFirstOn[n - 2] == '0') {
                    notFirstOn[n - 2] = '1';
                } else {
                    notFirstOn[n - 2] = '0';
                }
            }

            if (k == '1') {
                notFirstOn[n - 1] = '0';
                if (notFirstOn[n - 2] == '0') {
                    notFirstOn[n - 2] = '1';
                } else {
                    notFirstOn[n - 2] = '0';
                }
            }
        }

        // 첫번째 스위치 누른 경우
        if (firstOn[0] == '0') {
            firstOn[0] = '1';
        } else {
            firstOn[0] = '0';
        }

        if (firstOn[1] == '0') {
            firstOn[1] = '1';
        } else {
            firstOn[1] = '0';
        }

        int cnt2 = 1;
        for (int i = 1; i <= n - 2; i++) {
            if (firstOn[i - 1] != answer.charAt(i - 1)) {
                for (int j = i - 1; j <= i + 1; j++) {
                    if (firstOn[j] == '1') {
                        firstOn[j] = '0';
                    } else if (firstOn[j] == '0') {
                        firstOn[j] = '1';
                    }
                }
                cnt2++;
            }
        }

        if (firstOn[n - 1] != answer.charAt(n - 1)) {
            cnt2++;
            char k = firstOn[n - 1];
            if (k == '0') {
                firstOn[n - 1] = '1';
                if (firstOn[n - 2] == '0') {
                    firstOn[n - 2] = '1';
                } else {
                    firstOn[n - 2] = '0';
                }
            }

            if (k == '1') {
                firstOn[n - 1] = '0';
                if (firstOn[n - 2] == '0') {
                    firstOn[n - 2] = '1';
                } else {
                    firstOn[n - 2] = '0';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (notFirstOn[i] != answer.charAt(i)) {
                cnt = Integer.MAX_VALUE;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (firstOn[i] != answer.charAt(i)) {
                cnt2 = Integer.MAX_VALUE;
                break;
            }
        }

        if (cnt == Integer.MAX_VALUE && cnt2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(cnt, cnt2));
        }
    }
}
