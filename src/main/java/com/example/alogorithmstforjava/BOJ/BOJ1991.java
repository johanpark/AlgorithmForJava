package com.example.alogorithmstforjava.BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1991 {
    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }
    }
    static int n;
    static Map<Character, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {  // 인덱스 수정: 0부터 n-1까지
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            map.putIfAbsent(parent, new Node(parent));

            if (left != '.') {
                map.putIfAbsent(left, new Node(left));
                map.get(parent).left = map.get(left);
            }
            if (right != '.') {
                map.putIfAbsent(right, new Node(right));
                map.get(parent).right = map.get(right);
            }
        }

        preorder(map.get('A'));
        System.out.println();
        inorder(map.get('A'));
        System.out.println();
        postorder(map.get('A'));
    }

    // 전위 순회 : Root -> Left -> Right
    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회 : Left -> Root -> Right
    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    // 후위 순회 : Left -> Right -> Root
    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}