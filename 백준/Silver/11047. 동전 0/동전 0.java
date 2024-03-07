import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int won = Integer.parseInt(st.nextToken());
        int coin = 0;

        int [] num = new int[k];

        for(int i = 0; i < k ; i++)
        {
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = k-1 ; i >= 0 ; i--)
        {
            if(num[i] > won) continue;
            
            coin += won / num[i];
            int a = won / num[i];
            won -= num[i]*a;
        }

        System.out.println(coin);
    }
}
