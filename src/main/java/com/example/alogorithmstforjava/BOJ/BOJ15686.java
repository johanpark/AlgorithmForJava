package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    public static int getDistance(List<int[]> selectedChicken) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int hx = house[0];
            int hy = house[1];
            int minDistance = Integer.MAX_VALUE;

            for (int[] chicken : selectedChicken) {
                int cx = chicken[0];
                int cy = chicken[1];
                int distance = Math.abs(hx - cx) + Math.abs(hy - cy);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }

        return totalDistance;
    }

    public static void generateCombinations(List<int[]> selectedChicken, int start, int m) {
        if (selectedChicken.size() == m) {
            int currentDistance = getDistance(selectedChicken);
            minDistance = Math.min(minDistance, currentDistance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selectedChicken.add(chickens.get(i));
            generateCombinations(selectedChicken, i + 1, m);
            selectedChicken.remove(selectedChicken.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cell = Integer.parseInt(st.nextToken());
                if (cell == 1) {
                    houses.add(new int[]{i, j});
                } else if (cell == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        generateCombinations(new ArrayList<>(), 0, m);
        System.out.println(minDistance);
    }
}