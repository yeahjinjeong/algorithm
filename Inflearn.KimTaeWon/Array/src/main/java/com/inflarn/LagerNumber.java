package com.inflarn;

import java.util.ArrayList;
import java.util.Scanner;

public class LagerNumber {
    public static void main(String[] args) {
        LagerNumber lagerNumber = new LagerNumber();

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int[] array = new int[input];

        for (int i = 0; i < input; i++) {
            array[i] = sc.nextInt();
        }

        lagerNumber.solution(array);
    }

    public void solution(int[] array) {
        System.out.print(array[0] + " ");
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                System.out.print(array[i] + " ");
            }
        }
    }
}