package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1107 {
    static Set<Integer> brokens = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int brokenButton = Integer.parseInt(st.nextToken());
                brokens.add(brokenButton);
            }
        }
        System.out.println(minPress(target, brokens));
    }

    public static int minPress(int target, Set<Integer> brokens) {
        int start = 100;
        int minPress = Math.abs(target - start);

        for (int i = 0; i <= 999999; i++) {
            if (possibleNum(i, brokens)) {
                int press = String.valueOf(i).length() + Math.abs(i - target);
                minPress = Math.min(minPress, press);
            }
        }

        return minPress;
    }

    public static boolean possibleNum(int channel, Set<Integer> brokens) {
        String strChannel = String.valueOf(channel);
        for (char ch : strChannel.toCharArray()) {
            if (brokens.contains(ch - '0')) {
                return false;
            }
        }
        return true;
    }
}