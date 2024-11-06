package com.inflearn;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        Scanner sc = new Scanner(System.in);

        String first = sc.next();
        String second = sc.next();

        anagram.solution(first, second);
        anagram.solution2(first, second);
    }

    private void solution(String first, String second) {
        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> secondMap = new HashMap<>();

        for (char c : first.toCharArray()) {
            firstMap.put(c, firstMap.getOrDefault(c, 0) + 1);
        }

        for (char c : second.toCharArray()) {
            secondMap.put(c, secondMap.getOrDefault(c, 0) + 1);
        }

        boolean answer = true;

        for (char key : firstMap.keySet()) {
            if (!firstMap.get(key).equals(secondMap.get(key))) {
                answer = false;
                break;
            }
        }
        System.out.println(answer ? "YES" : "NO");
    }

    /**
     * 두 단어의 길이가 같다는 점을 이용해서 해쉬맵을 한 개만 써서 풀기
     */
    private void solution2(String first, String second) {
        boolean answer = true;
        HashMap<Character, Integer> firstMap = new HashMap<>();
        for (char c : first.toCharArray()) {
            firstMap.put(c, firstMap.getOrDefault(c, 0) + 1);
        }
        for (char c : second.toCharArray()) {
            if (!firstMap.containsKey(c) || firstMap.get(c) == 0) { answer = false; break; }
            firstMap.put(c, firstMap.get(c) - 1); // 여기서 빼줘서 0이 된다는 것은 first의 c개수가 second보다 적다라는 것을 의미함
            // 만약 first의 c개수가 second보다 많다면, first의 다른 c의 개수가 second보다 반드시 적을 것임
            // 두 단어의 길이가 같기 때문!
        }
        System.out.println(answer ? "YES" : "NO");
    }
}
