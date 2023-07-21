package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Integer> target = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            target.add(s);
        }
        List<Integer> collect = target.stream().sorted().collect(Collectors.toList());
        //산술평균
        int sum = collect.stream().mapToInt(Integer::intValue).sum() / target.size();
        //중앙값
        int middle = collect.get(collect.size() / 2);
        //최빈값
        //범위
        int max = collect.stream().mapToInt(x -> x).max().getAsInt();
        int min = collect.stream().mapToInt(x -> x).min().getAsInt();
        int range = max - min;


        System.out.println(sum);
        System.out.println(middle);
        System.out.println(range);
    }

    private static int findDuplicate(List<Integer> collect) {
        Integer tortoise = collect.get(0);
        Integer hare = collect.get(0);
        do {
            tortoise = collect.get(tortoise);
            hare = collect.get(collect.get(hare));
        } while (!Objects.equals(tortoise, hare));
        Integer ptr1 = collect.get(0);
        Integer ptr2 = tortoise;
        while(!Objects.equals(ptr1, ptr2)) {
            ptr1 = collect.get(ptr1);
            ptr2 = collect.get(ptr2);
        }
        return ptr1;
    }
}
