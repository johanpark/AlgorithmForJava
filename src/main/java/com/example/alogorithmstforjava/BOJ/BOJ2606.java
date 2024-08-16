package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(list, 1, visited);
        int count = 0;
        for (boolean b : visited) {
            if(b) {
                count++;
            }
        }
        System.out.println(count-1);
    }

    static void dfs(List<Integer>[] list, int node, boolean[] visited) {
        visited[node] = true;
        for (int nextNode : list[node]) {
            if(!visited[nextNode]) {
                dfs(list, nextNode, visited);
            }
        }
    }
}
