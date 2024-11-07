package com.inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class FindAllAnagram {
    public static void main(String[] args) {
        FindAllAnagram findAllAnagram = new FindAllAnagram();
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String T = sc.next();

        findAllAnagram.solution(S, T);
    }

    // HashSet은 왜 안 될까?
    // 중복되는 단어가 있기 때문에 remove를 할 수 없기 때문이다

    private void solution(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        int answer = 0;

        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length() - 1; i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            mapS.put(s.charAt(rt), mapS.getOrDefault(s.charAt(rt), 0) + 1);

            /*
            오답 :
            if (mapT.keySet().equals(mapS.keySet())) answer++;
            */

            if (mapT.equals(mapS)) answer++;

            mapS.put(s.charAt(lt), mapS.get(s.charAt(lt)) - 1);
            if (mapS.get(s.charAt(lt)) == 0) mapS.remove(s.charAt(lt));
            lt++;
        }

        System.out.println(answer);
    }
}
