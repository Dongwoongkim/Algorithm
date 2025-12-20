import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long n, k;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());

		System.out.println(binarySearch());
	}

	private static String binarySearch() {
		long start = 0;
		long end = n;

		while (start <= end) {
			long mid = (start + end) / 2;

			long h = mid + 1;
			long w = n + 1 - mid;
			long result = h * w;

			// System.out.println(h + " " + w);
			// System.out.println(result);

			if (result == k) {
				return "YES";
			}

			if (result < k) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return "NO";
	}
}
