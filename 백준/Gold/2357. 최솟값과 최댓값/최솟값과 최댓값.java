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

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        MinSegmentTree minTree = new MinSegmentTree(n);
        MaxSegmentTree maxTree = new MaxSegmentTree(n);

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long minValue = minTree.findMin(1, 1, n, a, b);
            //            tree.updateMin(1, minValue);
            long maxValue = maxTree.findMax(1, 1, n, a, b);
            sb.append(minValue + " " + maxValue).append("\n");
        }

        System.out.println(sb);
    }

    static class MaxSegmentTree {

        long[] tree;

        public MaxSegmentTree(int size) {
            tree = new long[size * 5];
            initTree(1, 1, size);

        }

        private long initTree(int root, int start, int end) {
            // 가장 끝에 도달한 경우
            if (start == end) {
                tree[root] = arr[start];
                return tree[root];
            }

            int mid = (start + end) / 2;

            tree[root] = Math.max(initTree(root * 2, start, mid), initTree(root * 2 + 1, mid + 1, end));

            return tree[root];
        }

        private long findMax(int root, int start, int end, int left, int right) {
            // 범위 밖
            if (left > end || right < start) {
                return Long.MIN_VALUE;
            }

            // 범위 안
            if (left <= start && right >= end) {
                return tree[root];
            }

            int mid = (start + end) / 2;

            // 자식 노드로부터 재귀적으로 탐색
            return Math.max(
                    findMax(root * 2, start, mid, left, right),
                    findMax(root * 2 + 1, mid + 1, end, left, right)
            );
        }
    }

    static class MinSegmentTree {

        long[] tree;

        public MinSegmentTree(int size) {
            tree = new long[size * 5];
            initTree(1, 1, size);

        }

        private long initTree(int root, int start, int end) {
            // 가장 끝에 도달한 경우
            if (start == end) {
                tree[root] = arr[start];
                return tree[root];
            }

            int mid = (start + end) / 2;

            tree[root] = Math.min(initTree(root * 2, start, mid), initTree(root * 2 + 1, mid + 1, end));

            return tree[root];
        }

        private long findMin(int root, int start, int end, int left, int right) {
            // 범위 밖
            if (left > end || right < start) {
                return Long.MAX_VALUE;
            }

            // 범위 안
            if (left <= start && right >= end) {
                return tree[root];
            }

            int mid = (start + end) / 2;

            // 자식 노드로부터 재귀적으로 탐색
            return Math.min(
                    findMin(root * 2, start, mid, left, right),
                    findMin(root * 2 + 1, mid + 1, end, left, right)
            );
        }
    }
}
