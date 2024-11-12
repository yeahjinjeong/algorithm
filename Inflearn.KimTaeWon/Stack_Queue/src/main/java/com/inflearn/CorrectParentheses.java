package com.inflearn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Stack = LIFO
 * Queue = FIFO
 *
 * 올바른 괄호 : 대표적인 Stack 구현 문제
 *
 * stack.push() : T
 * stack.pop() : T
 * stack.isEmpty() : boolean
 *
 * Deque와 Stack의 차이?
 * - Stack은 Vector 클래스를 상속하여 구현되어 있으나, 멀티 쓰레드 환경에 유리한 Vector가 성능상 느리고, 용량도 크기 때문에 권장되지 않는다.
 * - Deque는 양방향 큐로써, Queue의 인터페이스를 상속받아 구현되어 있다. Stack과 Queue에 대응되는 메소드들이 존재한다.
 * - ArrayDeque는 Deque의 구현체이다.
 */
public class CorrectParentheses {
    public static void main(String[] args) {
        CorrectParentheses correctParentheses = new CorrectParentheses();

        Scanner sc = new Scanner(System.in);

        String parentheses = sc.next();

        System.out.println(correctParentheses.solution(parentheses));
    }

    private String solution(String parentheses) {
        Deque<Character> stack = new ArrayDeque<>();
//        Stack<Character> stack = new Stack<>();

        for (char x : parentheses.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        return "NO";
    }
}