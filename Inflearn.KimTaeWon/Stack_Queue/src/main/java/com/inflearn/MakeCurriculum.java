package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MakeCurriculum {
    public static void main(String[] args) {
        MakeCurriculum makeCurriculum = new MakeCurriculum();

        Scanner sc = new Scanner(System.in);

        String required = sc.next();
        String made = sc.next();

        System.out.print(makeCurriculum.solution(required, made));
    }

    private String solution(String required, String made) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : required.toCharArray()) {
            queue.offer(c);
            if (!made.contains(String.valueOf(c))) return "NO";
        }

        for (char c : made.toCharArray()) {
            if (queue.contains(c)) {
                if (queue.poll() != c) return "NO";
            }
        }
        return "YES";
    }

    private String solution2(String required, String made) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : required.toCharArray()) {
            queue.offer(c);
        }

        for (char c : made.toCharArray()) {
            if (queue.contains(c)) {
                if (queue.poll() != c) return "NO";
            }
        }
        if (!queue.isEmpty()) return "NO";

        return "YES";
    }
}
