import java.io.IOException;

public class Main {

    private static byte[] buffer = new byte[78888905];
    private static int next = 0;
    private static int b;

    public static void main(String args[]) throws IOException {
        System.in.read(buffer, 0, buffer.length);

        long n = nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nextInt();
        }

        System.out.println(sum - (n * (n - 1) / 2));
    }

    private static long nextInt() {
        long n = buffer[next++] - '0';

        while ((b = buffer[next++]) >= '0') {
            n = (n * 10) + (b - '0');
        }

        return n;
    }
}
