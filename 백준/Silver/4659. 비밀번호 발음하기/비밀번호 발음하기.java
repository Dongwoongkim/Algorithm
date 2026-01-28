import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                break;
            }

            sb.append(getAnswer(line)).append("\n");
        }
        System.out.println(sb);
    }

    private static String getAnswer(String line) {
        boolean flag1 = false;
        boolean flag2 = true;
        boolean flag3 = true;

        if (line.contains("a") || line.contains("e") || line.contains("i") || line.contains("o") || line.contains("u")) {
            flag1 = true;
        }

        int moumCnt = 0;
        int zaumCnt = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                moumCnt++;
                zaumCnt = 0;
            } else {
                zaumCnt++;
                moumCnt = 0;
            }

            if (zaumCnt == 3 || moumCnt == 3) {
                flag2 = false;
                break;
            }
        }

        for (int i = 1; i < line.length(); i++) {
            char cur = line.charAt(i - 1);
            char next = line.charAt(i);

            if (cur == next) {
                if (next != 'e' && next != 'o') {
                    flag3 = false;
                    break;
                }
            }
        }

        boolean flag = false;
        if (flag1 && flag2 && flag3) {
            flag = true;
        }
        return "<" + line + ">" + " is " + (flag ? "acceptable." : "not acceptable.");
    }
}
