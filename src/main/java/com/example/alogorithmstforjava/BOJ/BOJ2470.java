package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2470 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(st.nextToken());
            list.add(m);
        }
        Collections.sort(list);

        int minSum = Integer.MAX_VALUE;
        int targetX = 0;
        int targetY = 0;
        for (int i = 0; i < n; i++) {
            Integer x = list.get(i);
            for(int j = i+1; j < n; j++) {
                Integer y = list.get(j);
                int abs = Math.abs(x + y);
                int min = Math.min(abs, minSum);
                if(minSum > min) {
                    minSum = min;
                    targetX = x;
                    targetY = y;
                }
            }
        }
        System.out.println(targetX + " " + targetY);
    }
}
