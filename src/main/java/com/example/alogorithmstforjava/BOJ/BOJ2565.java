package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] target = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            target[i][0] = first;
            target[i][1] = second;
        }
        //최장 증가 부분 수열
        Arrays.sort(target, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(n - findLIS(target, n));
    }

    private static int findLIS(int[][] target, int n) {
        int len = 0;
        int[] lis = new int[n];

        for(int i= 0; i < n; i++) {
            int position = Arrays.binarySearch(lis, 0, len, target[i][1]);
            if(position < 0) {
                position = -(position + 1);
            }
            lis[position] = target[i][1];
            if(position == len) {
                len++;
            }
        }
        return len;
    }
}