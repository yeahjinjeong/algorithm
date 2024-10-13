package org.example;

import java.util.Scanner;

/**
 * 1. 문자 찾기
 */
public class FindCharacter {
    public static void main(String[] args){
        FindCharacter findCharacter = new FindCharacter();

        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        char input2 = sc.next().charAt(0);

        // idea : 아예 다 대문자로 만들어버려서 비교를 하자!
        input1 = input1.toUpperCase();
        input2 = Character.toUpperCase(input2);

        System.out.println(findCharacter.solution(input1, input2));
        System.out.println(findCharacter.solution2(input1, input2));
    }

    public int solution(String str, char c) {
        int sum = 0;
        // 향상된 for문에는 String (X) 배열 쓰기!
        for(char x : str.toCharArray()) {
            if (c == x) {
                sum ++;
            }
        }
        return sum;
    }

    public int solution2(String str, char c) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                sum += 1;
            }
        }
        return sum;
    }
}
