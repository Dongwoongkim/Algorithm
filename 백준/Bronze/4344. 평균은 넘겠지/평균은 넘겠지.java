import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();

            int[] score = new int[k];
            int sum=0;
            for (int j = 0; j < k; j++) {
                score[j] = sc.nextInt();
                sum += score[j];
            }
            double aver = (double) sum/k;
            int g = 0;
            for (int j = 0; j < k; j++) {
                if(score[j]>aver)
                {
                    g++;
                }
            }
            System.out.printf("%.3f%%\n",(double)(g)/k * 100);
        }
    }
}


