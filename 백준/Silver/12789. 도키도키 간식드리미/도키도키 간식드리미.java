import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(getAnswer(arr));
    }

    private static String getAnswer(List<Integer> arr) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            st1.push(arr.get(i));
        }

        int consequence = 1;

        while (!st1.isEmpty()) {

            if (!st1.isEmpty() && st1.peek() == consequence) {
                st1.pop();
                consequence++;
                continue;
            }

            if (!st2.isEmpty() && st2.peek() == consequence) {
                st2.pop();
                consequence++;
                continue;
            }

            if (st1.peek() != consequence) {
                st2.push(st1.pop());
            }
        }
        
        if (st2.isEmpty()) {
            return "Nice";
        }

        while (true) {
            Integer top = st2.pop();
            if (st2.isEmpty()) {
                break;
            }
            Integer next = st2.peek();
            if (top > next) {
                return "Sad";
            }
        }

        return "Nice";
    }
}
