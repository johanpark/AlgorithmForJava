package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] frequency = new int[8001];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            frequency[nums[i]+4000]++;
        }
        br.close();

        //산술평균
        double mean = (double) sum / N;
        System.out.println(Math.round(mean));

        //중앙값
        Arrays.sort(nums);
        int median = nums[N / 2];
        System.out.println(median);

        //최빈값
        int maxFrequency = Arrays.stream(frequency).max().getAsInt();
        ArrayList<Integer> target = new ArrayList<>();
        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] == maxFrequency) {
                target.add(i - 4000);
            }
        }
        Collections.sort(target);
        Integer result = target.get(0);
        if(target.size() > 1) {
            result = target.get(1);
        }
        System.out.println(result);

        //범위
        int range = max - min;
        System.out.println(range);
    }
}
