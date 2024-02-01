package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //i는 위치값, 해당 위치에 num값이 들어가고 count가 같아지는 순간에 num을 하나 늘이고 count를 0으로 해준다.
        int result = 0;
        int num = 1;
        int count = 0;
        for (int i = 1; i <= m; i++) {
            if (count == num) {
                num++;
                count = 0;
            }
            if (i >= n) {
                result += num;
            }
            count++;
        }

        System.out.println(result);
    }
}
