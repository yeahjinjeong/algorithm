package org.example;

import java.util.Scanner;

/**
 * 8. 유효한 팰린드롬
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(validPalindrome.solution(input.toUpperCase()));
        System.out.println(validPalindrome.solution2(input.toUpperCase()));
    }

    // 나의 답
    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        String reversed = sb.reverse().toString();
        if (str.equals(reversed)) {
            return "YES";
        }
        return "NO";
    }

    // 강의 답
    public String solution2(String str) {
        str = str.replaceAll("[^A-Z]", "");
        String reversed = new StringBuilder(str).reverse().toString();
        if (str.equals(reversed)) {
            return "YES";
        }
        return "NO";
    }
}
