package com.example.alogorithmstforjava.BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class softeer_class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            dp[i][0] = scanner.nextInt();
            dp[i][1] = scanner.nextInt();
        }
        Arrays.sort(dp, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));

        int count = 1;
        int endPoint = dp[0][1];
        for (int i = 0; i < N; i++) {
            if(dp[i][0] >= endPoint) {
                endPoint = dp[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
