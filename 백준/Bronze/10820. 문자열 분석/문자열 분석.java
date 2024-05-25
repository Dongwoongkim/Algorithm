import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;

            for (int i = 0; i < s.length(); i++) {
                if (Character.isLowerCase(s.charAt(i))) {
                    a++;
                }
                if (Character.isUpperCase(s.charAt(i))) {
                    b++;
                }
                if (Character.isDigit(s.charAt(i))) {
                    c++;
                }
                if (s.charAt(i) == ' ') {
                    d++;
                }
            }
            System.out.print(a + " " + b + " " + c + " " + d + "\n");
        }

    }
}
