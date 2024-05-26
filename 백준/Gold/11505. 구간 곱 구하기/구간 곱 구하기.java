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
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree tree = new SegmentTree(n);

        for (int i = 0; i < m + k; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // idx b 번째 수 -> c로 바꾸기
            if (a == 1) {
                tree.update(1, 1, n, b, c);
            }

            // [b,c] 구간 곱 출력
            if (a == 2) {
                sb.append(tree.find(1, 1, n, b, (int) c)).append("\n");
            }
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

            tree[root] = (initTree(root * 2, start, mid) * initTree(root * 2 + 1, mid + 1, end)) % 1_000_000_007;

            return tree[root];
        }

        private long find(int root, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 1;
            }

            // 범위 안에 있는 경우
            if (left <= start && right >= end) {
                return tree[root] % 1_000_000_007;
            }

            int mid = (start + end) / 2;

            // 자식 노드로부터 재귀적으로 탐색
            return (find(root * 2, start, mid, left, right) * find(root * 2 + 1, mid + 1, end, left, right))
                    % 1_000_000_007;
        }

        private long update(int root, int start, int end, int changeIdx, long value) {
            // 범위 밖에 있으면 변경 X
            if (changeIdx < start || changeIdx > end) {
                return tree[root];
            }

            // 리프노드에 다다르면 갱신
            if (start == end) {
                tree[root] = value;
                arr[start] = value;
                return tree[root];
            }

            int mid = (start + end) / 2;

            tree[root] = update(root * 2, start, mid, changeIdx, value) *
                    update(root * 2 + 1, mid + 1, end, changeIdx, value) % 1_000_000_007;

            return tree[root];
        }
    }
}
