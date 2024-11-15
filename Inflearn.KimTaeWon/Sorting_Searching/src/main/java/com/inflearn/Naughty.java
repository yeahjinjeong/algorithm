package com.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Naughty {
    public static void main(String[] args) {
        Naughty naughty = new Naughty();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : naughty.solution(n, arr)) {
            System.out.print(i + " ");
        }

        for (int i : naughty.solution2(n, arr)) {
            System.out.print(i + " ");
        }
    }

    private ArrayList<Integer> solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (tmp[i] != arr[i]) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    private ArrayList<Integer> solution(int n, int[] arr) {
        int lt = 0, rt = n-1;

        int CHEOLSU = 0;
        int pair = 0;

        ArrayList<Integer> answer = new ArrayList<>();
        while (CHEOLSU == 0 || pair == 0 && lt != rt) {
            if (arr[lt] > arr[lt+1]) CHEOLSU = lt + 1;
            if (arr[rt-1] > arr[rt]) pair = rt + 1;

            lt++;
            rt--;
        }

        answer.add(CHEOLSU);
        answer.add(pair);
        return answer;
    }


}
