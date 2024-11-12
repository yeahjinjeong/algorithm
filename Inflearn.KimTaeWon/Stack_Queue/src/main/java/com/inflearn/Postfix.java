package com.inflearn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        Postfix postfix = new Postfix();

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        postfix.solution(str);
        postfix.solution2(str);
    }

    private void solution(String str) {
        Deque<Integer> stack = new ArrayDeque<>();

        int a = 0, b = 0;
        for (char x : str.toCharArray()) {
            switch (x) {
                case '+' : a = stack.pop(); b = stack.pop(); stack.push(b+a);
                    break;
                case '-' : a = stack.pop(); b = stack.pop(); stack.push(b-a);
                    break;
                case '*' : a = stack.pop(); b = stack.pop(); stack.push(b*a);
                    break;
                case '/' : a = stack.pop(); b = stack.pop(); stack.push(b/a);
                    break;
                default: if (Character.isDigit(x)) stack.push(Integer.parseInt(String.valueOf(x)));
                    break;
            }
        }
        System.out.println(stack.pop());
    }

    private void solution2(String str) {
        Deque<Integer> stack = new ArrayDeque<>();

        int a = 0, b = 0;
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) stack.push(x-48);
            else {
                a = stack.pop(); b = stack.pop();
                switch (x) {
                    case '+' : stack.push(b+a);
                        break;
                    case '-' : stack.push(b-a);
                        break;
                    case '*' : stack.push(b*a);
                        break;
                    case '/' : stack.push(b/a);
                        break;
                    default: break;
                }
            }
        }
        System.out.println(stack.pop());
    }
}
