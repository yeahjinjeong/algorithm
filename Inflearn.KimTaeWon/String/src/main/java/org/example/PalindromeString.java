package org.example;

import java.util.Scanner;

/**
 * 7. 회문 문자열
 */
public class PalindromeString {
    public static void main(String[] args) {
        PalindromeString palindromeString = new PalindromeString();

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(palindromeString.solution(input.toUpperCase()));
        System.out.println(palindromeString.solution2(input.toUpperCase()));
        System.out.println(palindromeString.solution3(input.toUpperCase()));
        System.out.println(palindromeString.solution4(input.toUpperCase()));
    }

    // 나의 답
    public String solution(String str) {
        int lt = 0, rt = str.length() - 1;
        char[] chars = str.toCharArray();
        while (lt < rt) {
            if (chars[lt] != chars[rt]) return "NO";
            lt ++;
            rt --;
        }
        return "YES";
    }

    // 강의 답 1
    public String solution2(String str) {
        for (int i = 0; i < str.length() / 2 ; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return "NO";
        }
        return "YES";
    }

    // 강의 답 1 참고한 나의 방식
    public String solution3(String str) {
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) return "NO";
            lt ++;
            rt --;
        }
        return "YES";
    }

    // 강의 답 2
    public String solution4(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        if (str.equals(reversedStr)) return "YES";
        return "NO";
    }
}