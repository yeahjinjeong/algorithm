package org.example;

import java.util.Scanner;

/**
 * 3. 문장 속 단어
 */
public class WordInSentence {
    public static void main(String[] args) {
        WordInSentence wordInSentence = new WordInSentence();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(wordInSentence.solution(input));
    }

    public String solution(String str) {
        String[] strings = str.split(" ");
        int max = 0;
        String result = "";
        for (String s : strings) {
            if (s.length() > max) {
                max = s.length();
                result = s;
            }
        }
        return result;
    }
}
