package com.inflearn;

import java.util.Scanner;

public class VisibleStudent {
    public static void main(String[] args) {
        VisibleStudent visibleStudent = new VisibleStudent();

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int[] array = new int[input];

        for (int i = 0; i < input; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(visibleStudent.solution(input, array));
    }

    public int solution(int input,int[] array) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < input; i++) {
            if (array[i] > max) {
                sum ++;
                max = array[i];
            }
        }
        return sum;
    }
}
