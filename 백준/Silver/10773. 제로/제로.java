import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();

            if (number == 0) {
                st.pop();
                continue;
            }

            st.push(number);
        }

        System.out.println(st.stream().mapToInt(Integer::intValue).sum());
    }
}
