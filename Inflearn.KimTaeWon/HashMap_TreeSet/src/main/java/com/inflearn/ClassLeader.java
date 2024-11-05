package com.inflearn;

import java.util.HashMap;
import java.util.Scanner;

/**
 * map.containsKey('A');
 * map.size();
 * map.remove('A'); return value
 */

public class ClassLeader {
    public static void main(String[] args) {
        ClassLeader classLeader = new ClassLeader();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        classLeader.solution(n, s);
    }

    private void solution(int n, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        char answer = ' ';

        for (char key : map.keySet()) {
            if (map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
    }
}