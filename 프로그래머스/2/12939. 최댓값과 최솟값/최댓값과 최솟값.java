import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();

        List<Integer> arr = new ArrayList<>();

        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        sb.append(arr.get(0) + " ");
        sb.append(arr.get(arr.size()-1));
        return sb.toString();
    }
}