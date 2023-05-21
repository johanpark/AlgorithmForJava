package com.example.alogorithmstforjava.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        List<String> target = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            StringTokenizer st = new StringTokenizer((br.readLine()));
            String s = st.nextToken();
            target.add(s);
        }

        for (int i = 0; i < target.get(0).length(); i++) {
            List<Integer> checkList = new ArrayList<>();
            for (String s : target) {
                int sliceNum = Integer.parseInt(s.substring(s.length() - i));
                checkList.add(sliceNum);
            }
            Set<Integer> targetSet = new HashSet<>(checkList);
            if (targetSet.size() == checkList.size()) {
                System.out.println(i);
                break;
            }
        }
    }
}
