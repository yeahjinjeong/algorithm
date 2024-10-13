package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestDistanceOfCharacter {
    public static void main(String[] args) {
        ShortestDistanceOfCharacter shortestDistanceOfCharacter = new ShortestDistanceOfCharacter();

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        char input2 = sc.next().charAt(0);

        shortestDistanceOfCharacter.solution(input, input2);
        shortestDistanceOfCharacter.solution2(input, input2);
    }

    public void solution(String str, char c) {
        int length = str.length();
        int[] distance = new int[length];
        char[] chars = str.toCharArray();

        Arrays.fill(distance, 1000);

        for (int i = 0; i < length; i++) {
            if (chars[i] == c) {
                for (int j = 0; j < length; j++) {
                    int tmp = Math.abs(i - j);
                    if (distance[j] > tmp) distance[j] = tmp;
                }
            }
        } // O(n^2)

        String answer = Arrays.toString(distance).replaceAll(",", "");
        answer = answer.substring(1, answer.length() - 1);
        System.out.println(answer);
    }

    public void solution2(String str, char c) {
        int[] distance = new int[str.length()];
        int p = 1000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0;
                distance[i] = p;
            } else {
                p++;
                distance[i] = p;
            }
        } // O(n)
        p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) p = 0;
            else {
                p++;
                distance[i] = Math.min(distance[i], p);
            }
        } // O(n)
        // O(2n) = O(n)
        for (int x : distance) System.out.print(x + " ");
    }
}
