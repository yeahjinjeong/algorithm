package com.inflearn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * Stack<Charcater> stack = new Stack<>();
 * stack.get(index) 사용 가능
 */

public class EliminateParentheses {
    public static void main(String[] args) {
        EliminateParentheses eliminateParentheses = new EliminateParentheses();

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        eliminateParentheses.solution(str);
    }

    private void solution(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char x : str.toCharArray()) {
            stack.push(x);
            if (x == ')') {
                while (stack.pop() != '(');
            }
        }

        String answer = "";
        for (char x : stack) {
            answer = x + answer;
        }
        System.out.println(answer);

        answer = "";
        for (int i = stack.size()-1; i >= 0; i--) {
            answer += stack.stream().toList().get(i); // 꺼낸 것을 뒤로 더함
        }
        System.out.println(answer);

        answer = "";
        for (int i = 0; i < stack.size(); i++) {
            answer = stack.stream().toList().get(i) + answer; // 꺼낸 것을 앞에 더함
//            System.out.print(stack.get(i)); // Deque 아닌 Stack을 썼을 때
        }
        System.out.println(answer);
    }
}
