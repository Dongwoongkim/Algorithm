import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int[] alphabet = new int[27];
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            alphabet[line.charAt(i) - 65]++;
        }

        for (int i = 0; i < 27; i++) {
            if (alphabet[i] % 2 == 1) {
                cnt++;
            }
        }

        if (cnt >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else if (cnt == 0) {
            String ans = "";
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] >= 2) {
                    for (int l = 0; l < alphabet[i] / 2; l++) {
                        ans += (char) (i + 65);
                    }
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (alphabet[i] >= 2) {
                    for (int l = 0; l < alphabet[i] / 2; l++) {
                        ans += (char) (i + 65);
                    }
                }
            }
            System.out.println(ans);
        } else if (cnt == 1) {
            String ans = "";

            int k = 0;
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] >= 2) {
                    for (int l = 0; l < alphabet[i] / 2; l++) {
                        ans += (char) (i + 65);
                    }
                }
                if (alphabet[i] % 2 == 1) {
                    k = i;
                }
            }

            ans += (char) (k + 65);

            for (int i = 25; i >= 0; i--) {
                if (alphabet[i] >= 2) {
                    for (int l = 0; l < alphabet[i] / 2; l++) {
                        ans += (char) (i + 65);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
