package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int pivot = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while(!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (poll >= pivot) {
                count++;
                pivot++;
                pq.offer(poll - 1);
            }
        }
        System.out.println(count);
    }
}
