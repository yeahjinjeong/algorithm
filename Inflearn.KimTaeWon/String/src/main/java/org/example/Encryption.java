package org.example;

import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Encryption encryption = new Encryption();

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String input = sc.next();
        encryption.solution(size, input);
        encryption.solution2(size, input);
    }

    public void solution(int size, String str) {
        StringBuilder sb = new StringBuilder();
        String div;
        int ascii;
        int squared;
        for (int i = 0; i < str.length(); i += str.length() / size) {
            div = str.substring(i, i + str.length() / size);
            String decimal = div.replace('#', '1').replace('*', '0');
            ascii = 0;
            squared = 1;
            int dec = Integer.parseInt(decimal);
            for (int j = dec; j > 0; j /= 10) {
                ascii = ascii + j % 10 * squared;
                squared *= 2;
            }
            sb.append((char) ascii);
        }
        System.out.println(sb.toString());
    }

    public void solution2(int size, String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < size; i++) {
            String div = str.substring(0, length / size).replace('#', '1').replace('*', '0');
            int ascii = Integer.parseInt(div, 2); // radix : 기수(진수)
            sb.append((char) ascii);
            str = str.substring(length / size);
        }
        System.out.println(sb.toString());
    }
}