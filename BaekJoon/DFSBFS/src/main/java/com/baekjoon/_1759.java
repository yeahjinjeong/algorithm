package com.baekjoon;

import java.util.*;

public class _1759 {
    static int L, C;
    static int[] visit;
    static String aeiou = "aeiou";
    static List<Character> characters;
    static PriorityQueue<String> answers;
    public static void main(String[] args) {
        _1759 _1759 = new _1759();

        Scanner sc = new Scanner(System.in);
        L = sc.nextInt(); // 몇 자리
        characters = new ArrayList<>();

        C = sc.nextInt(); // 후보군
        visit = new int[C];
        for (int i = 0; i < C; i++) {
            characters.add(sc.next().charAt(0));
        }
        Collections.sort(characters);

//        for (char c : characters) {
//            System.out.println(c);
//        }

        answers = new PriorityQueue<>();

        // 최소 한 개의 모음, 최소 두 개의 자음
        _1759.DFS(0, 0, 0, "");

        while (!answers.isEmpty()) {
            System.out.println(answers.poll());
        }
    }

    private void DFS(int vowel, int consonant, int count, String s) {
        if (count == L) {
            if (vowel >= 1 && consonant >= 2) answers.add(s);
        }
        for (int i = 0; i < C; i++) {
            if (visit[i] == 1) break;
            visit[i] = 1;
            if (aeiou.contains(characters.get(i).toString())) {
                DFS(vowel + 1, consonant, count + 1, characters.get(i) + s);
            } else {
                DFS(vowel, consonant + 1, count + 1,  characters.get(i) + s);
            }
            visit[i] = 0;
        }
    }
}
