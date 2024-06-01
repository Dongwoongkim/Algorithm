class Solution {
    public int solution(int num) {
        if (num == 1) {
            return 0;
        }

        int cnt = 0;
        while (true) {
            if (num == 1) {
                break;
            }

            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 2 == 1) {
                num = num * 3 + 1;
            }

            cnt++;
            if (cnt >= 500) {
                return -1;
            }
        }

        return cnt;
    }
}