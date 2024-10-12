package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EliminateDuplicatedCharacter {
    public static void main(String[] args) {
        EliminateDuplicatedCharacter eliminateDuplicatedCharacter = new EliminateDuplicatedCharacter();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(eliminateDuplicatedCharacter.solution(input));
    }

    public String solution(String str) {
        String answer = "";
        for (int i=0; i<str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i)
                answer += str.charAt(i);
        }
        return answer;
    }
}
