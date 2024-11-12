package com.inflearn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MetalStick {
    public static void main(String[] args) {
        MetalStick metalStick = new MetalStick();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        metalStick.solution(str);
    }

    private void solution(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        int answer = 0;
        stack.push('(');
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                stack.pop();
                if (str.charAt(i-1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            } else stack.push(str.charAt(i));
        }
        System.out.println(answer);
    }

    // 나는 천재인가바~.~
}
