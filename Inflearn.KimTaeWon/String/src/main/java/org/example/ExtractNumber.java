package org.example;

import java.util.Scanner;

/**
 * 9. 숫자만 추출
 */
public class ExtractNumber {
    public static void main(String[] args) {
        ExtractNumber extractNumber = new ExtractNumber();

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        extractNumber.solution(input);
        extractNumber.solution2(input);
        extractNumber.solution3(input);
    }

    private void solution(String str) {
        str = str.replaceAll("[^0-9]", "");
        int answer = Integer.parseInt(str);
        System.out.println(answer);
    }

    private void solution2(String str) {
        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c >= 48 && c < 57) {
                answer = answer * 10 + (c - 48); // 왼쪽으로 한 자릿수 이동, 아스키 코드를 숫자로 변환
            }
        }
        System.out.println(answer);
    }

    private void solution3(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }
        System.out.println(Integer.parseInt(answer));
    }
}
