package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7569 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, h;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] graph;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        graph = new int[h][n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if(graph[i][j][k] == 1) q.add(new int[]{i, j, k});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 6; i++) {
                int z = poll[0] + dz[i];
                int x = poll[1] + dx[i];
                int y = poll[2] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && z >= 0 && z < h) {
                    if (graph[z][x][y] == 0) {
                        graph[z][x][y] = graph[poll[0]][poll[1]][poll[2]] + 1;
                        q.add(new int[]{z, x, y});
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (graph[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, graph[i][j][k]);
                }
            }
        }
        System.out.println(result - 1);
    }
}