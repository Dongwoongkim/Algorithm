import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String first = st.nextToken();
        String second = st.nextToken();

        int maxLength = Math.max(first.length(), second.length());

        StringBuilder a = new StringBuilder(String.valueOf(0).repeat(maxLength - first.length() + 1));
        StringBuilder b = new StringBuilder(String.valueOf(0).repeat(maxLength - second.length() + 1));
        StringBuilder c = new StringBuilder(String.valueOf(0).repeat(maxLength + 1));

        a = new StringBuilder(a.toString() + first);
        b = new StringBuilder(b.toString() + second);

        for (int i = a.length() - 1; i >= 0; i--) {
            char aNumber = a.toString().charAt(i);
            char bNumber = b.toString().charAt(i);
            char cNumber = c.toString().charAt(i);

            int num = (aNumber - '0') + (bNumber - '0') + (cNumber - '0');

            if (num < 10) {
                sb.append(num);
            } else {
                sb.append(num - 10);
                c.setCharAt(i - 1, '1');
            }
        }

        String answer = sb.reverse().toString();

        if (answer.charAt(0) == '0') {
            answer = answer.substring(1, answer.length());
        }
        System.out.println(answer);
    }
}
