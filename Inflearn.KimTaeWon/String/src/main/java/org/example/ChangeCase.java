package org.example;
import java.util.Scanner;

/**
 * 2. 대소문자 변환
 */
public class ChangeCase {
    public static void main(String[] args) {
        ChangeCase changeCase = new ChangeCase();

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(changeCase.solution(input));
    }

    public String solution(String str) {
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            // 대문자 65 ~ 90 // 소문자 97 ~ 122
            if (c >= 65 && c <= 90) {
                result += (char)(c - 32);
            } else if (c >= 97 && c <= 122) {
                result += (char)(c + 32);
            }

            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }
        return sb.toString();
    }
}
