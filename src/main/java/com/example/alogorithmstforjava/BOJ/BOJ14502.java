package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    static int n, m;
    static int[][] maze;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int s = Integer.parseInt(st.nextToken());
                maze[i][j] = s;
            }
        }
        setWall(0);
        System.out.println(result);
    }

    static void setWall(int count){
        if(count == 3) {
            int[][] copyMaze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copyMaze[i][j] = maze[i][j];
                }
            }
            spreadVirus(copyMaze);
            result = Math.max(result, countSafe(copyMaze));
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j]== 0) {
                    maze[i][j] = 1;
                    setWall(count+1);
                    maze[i][j] = 0;
                }
            }
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static void spreadVirus(int[][] maze) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 0) {
                    maze[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

    }

    static int countSafe(int[][] maze) {
        int count = 0;
        for (int[] ints : maze) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
