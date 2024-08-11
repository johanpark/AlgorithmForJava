package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new ArrayList[n];

        // 1. 노드 구성
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        int targetNode = Integer.parseInt(br.readLine());

        if (targetNode == root) {
            // 루트 노드가 삭제되면 전체 트리가 사라지므로 리프 노드는 0개
            System.out.println(0);
        } else {
            // 2. 노드 삭제
            deleteNode(tree, targetNode);
            // 3. 리프 노드 count
            int countLeafNodes = countLeafNodes(tree, root);
            System.out.println(countLeafNodes);
        }
    }

    static void deleteNode(List<Integer>[] tree, int node) {
        // 자식 노드들을 모두 삭제
        for (int child : tree[node]) {
            deleteNode(tree, child);
        }
        tree[node].clear();

        // 부모 노드에서도 이 노드를 삭제
        for (int i = 0; i < tree.length; i++) {
            tree[i].remove(Integer.valueOf(node));
        }
    }

    static int countLeafNodes(List<Integer>[] tree, int node) {
        if (tree[node].isEmpty()) {
            return 1;
        }
        int count = 0;
        for (int child : tree[node]) {
            count += countLeafNodes(tree, child);
        }
        return count;
    }
}