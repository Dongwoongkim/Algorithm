import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            left.add(line.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");

            if (commands[0].equals("D")) {
                if (!right.isEmpty()) {
                    left.add(right.pop());
                }
            }

            if (commands[0].equals("L")) {
                if (!left.isEmpty()) {
                    right.add(left.pop());
                }
            }

            if (commands[0].equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            }

            if (commands[0].equals("P")) {
                char c = commands[1].charAt(0);
                left.add(c);
            }

        }

        for (Character c : left) {
            sb.append(c);
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
