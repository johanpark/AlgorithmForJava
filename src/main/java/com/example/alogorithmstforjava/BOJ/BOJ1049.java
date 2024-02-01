package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int setLineMin = Integer.MAX_VALUE;
        int oneLineMin = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int setLinePrice = Integer.parseInt(st.nextToken());
            int oneLinePrice = Integer.parseInt(st.nextToken());

            setLineMin = Math.min(setLineMin, setLinePrice);
            oneLineMin = Math.min(oneLineMin, oneLinePrice);
        }
        int result = 0;
        int oneLineSetPrice = oneLineMin * 6;
        if (setLineMin > oneLineSetPrice) {
            result = oneLineMin * N;
        } else {
            result = (N / 6) * setLineMin;
            int oneLineCost = (N % 6) * oneLineMin;
            result += Math.min(oneLineCost, setLineMin);
        }
        System.out.println(result);
    }
}
