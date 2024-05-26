import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] tree = new int[27][2];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char p = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if (l == '.') {
                tree[(int) p - 65][0] = -1;
            } else {
                tree[(int) p - 65][0] = (int) (l - 65);
            }

            if (r == '.') {
                tree[(int) p - 65][1] = -1;
            } else {
                tree[(int) p - 65][1] = (int) (r - 65);
            }
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);

        System.out.println(sb);
    }

    private static void preOrder(int i) {
        if (i == -1) {
            return;
        }

        sb.append(((char) (i + 65)));
        preOrder(tree[i][0]);
        preOrder(tree[i][1]);
    }

    private static void inOrder(int i) {
        if (i == -1) {
            return;
        }

        inOrder(tree[i][0]);
        sb.append(((char) (i + 65)));
        inOrder(tree[i][1]);
    }

    private static void postOrder(int i) {
        if (i == -1) {
            return;
        }

        postOrder(tree[i][0]);
        postOrder(tree[i][1]);
        sb.append(((char) (i + 65)));
    }
}
