package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bag_weight {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int W = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] metals = new int[N][2];

        for (int i = 0; i < N; i++) {
            metals[i][0] = scanner.nextInt(); // 무게
            metals[i][1] = scanner.nextInt(); // 가격
        }

        Arrays.sort(metals, Comparator.comparingInt(arr -> -arr[1]));
        int value = 0;
        for (int[] metal : metals) {
            if(metal[0] <= W) {
                W = W - metal[0];
                value += (metal[0] * metal[1]);
            } else {
                value += (W * metal[1]);
                break;
            }
        }
        System.out.println(value);
    }
}
