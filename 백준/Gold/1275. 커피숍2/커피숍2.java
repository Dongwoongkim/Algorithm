import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(n);

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            if (x < y) {
                sb.append(tree.find(1, 1, n, x, y)).append("\n");

            } else {
                sb.append(tree.find(1, 1, n, y, x)).append("\n");
            }
            tree.update(1, 1, n, a, b - arr[a]);
            arr[a] = b;
        }

        System.out.println(sb);
    }

    static class SegmentTree {
        long[] tree;

        public SegmentTree(int size) {
            tree = new long[size * 4];
            initTree(1, 1, size);
        }

        private long initTree(int root, int start, int end) {
            // 가장 끝에 도달한 경우
            if (start == end) {
                tree[root] = arr[start];
                return tree[root];
            }

            int mid = (start + end) / 2;

            tree[root] = initTree(root * 2, start, mid) + initTree(root * 2 + 1, mid + 1, end);

            return tree[root];
        }

        private long find(int root, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            // 범위 안에 있는 경우
            if (left <= start && end <= right) {
                return tree[root];
            }

            int mid = (start + end) / 2;

            // 자식 노드로부터 재귀적으로 탐색
            return find(root * 2, start, mid, left, right) + find(root * 2 + 1, mid + 1, end, left, right);
        }

        private void update(int root, int start, int end, int changeIdx, long diff) {
            // 범위 밖에 있으면 변경 X
            if (changeIdx < start || changeIdx > end) {
                return;
            }

            // 범위 안에 있으면 내려가면서 갱신
            tree[root] += diff;

            // 리프 노드인 경우
            if (start == end) {
                return;
            }

            int mid = (start + end) / 2;

            // 왼쪽 자식 갱신
            update(root * 2, start, mid, changeIdx, diff);

            // 오른쪽 자식 갱신
            update(root * 2 + 1, mid + 1, end, changeIdx, diff);
        }
    }
}
