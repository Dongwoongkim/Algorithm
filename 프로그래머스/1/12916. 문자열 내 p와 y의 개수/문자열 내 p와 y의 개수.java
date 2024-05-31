class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int cntP = 0;
        int cntY = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p' || c == 'P') {
                cntP++;
            }

            if (c == 'y' || c == 'Y') {
                cntY++;
            }
        }
        
        return cntP == cntY;
    }
}