package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int pieces = 0;
        boolean preclose = false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push(string.charAt(i));
                pieces++;
                preclose = false;
            } else {
                stack.pop();
                if (!preclose) {
                    pieces--;
                    pieces += stack.size();
                }
                preclose = true;
            }
        }
        System.out.println(pieces);
    }
}
