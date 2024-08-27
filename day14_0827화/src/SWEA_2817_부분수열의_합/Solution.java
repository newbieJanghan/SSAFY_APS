package SWEA_2817_부분수열의_합;

import java.util.Scanner;

public class Solution {
    static int N, K, count;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            numbers = new int[N];
            count = 0;
            for (int i = 0; i < N; i++) {
                numbers[i] = sc.nextInt();
            }

            for (int i = 0; i < (1 << N); i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) > 0) {
                        sum += numbers[j];
                    }
                }
                if (sum == K) {
                    count++;
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}