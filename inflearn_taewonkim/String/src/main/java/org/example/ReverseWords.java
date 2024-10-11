package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 4. 단어 뒤집기
 *
 * String 객체가 있음에도 불구하고 StringBuilder를 쓰는 이유?
 * String은 원래 불변 객체이다
 * 그래서 변경을 해도 새로운 객체를 만들어서 대입하는 과정으로 이루어진다
 * 이는 메모리 낭비가 심하다
 */
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            stringList.add(sc.next());
        }
        reverseWords.solution(stringList);
    }

    public void solution(List<String> strings) {
        for (String str : strings) {
            StringBuilder stringBuilder = new StringBuilder(str);
            System.out.println(stringBuilder.reverse());
        }
    }
}
