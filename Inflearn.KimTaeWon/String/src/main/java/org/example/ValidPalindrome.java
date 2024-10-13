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
    }

    public String solution(String str) {
        // 나의 답
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            if (Character.isAlphabetic(str.charAt(i))) {
//                sb.append(str.charAt(i));
//            }
//        }
        // 강의 답
        str = str.replaceAll("[^A-Z]", "");
        String reversed = new StringBuilder(str).reverse().toString();
        if (str.equals(reversed)) {
            return "YES";
        }
        return "NO";
    }
}
