package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        int resultNum1 = 0;
        int resultNum2 = 0;
        int product = lcm / gcd;

        for(int i = 1; i * i <= product; i++) {
            if(product % i == 0) {
                int n = i;
                int m = product / i;
                if(gcd(n, m) == 1) {
                    resultNum1 = n * gcd;
                    resultNum2 = m * gcd;
                }
            }
        }
        System.out.println(resultNum1 + " " + resultNum2);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
