package com.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockScissorsPaper {
    public static void main(String[] args) {
        RockScissorsPaper rockScissorsPaper = new RockScissorsPaper();

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        sc.nextLine();
        String[] a = sc.nextLine().split(" ");
        List<Integer> A = new ArrayList<>();
        for (String s : a) {
            A.add(Integer.parseInt(s));
        }
        String[] b = sc.nextLine().split(" ");
        List<Integer> B = new ArrayList<>();
        for (String s : b) {
            B.add(Integer.parseInt(s));
        }
        rockScissorsPaper.solution(input, A, B);
    }

    public void solution(int n, List<Integer> A, List<Integer> B) {
        for (int i = 0; i < n; i++) {
            String winner = "";
            if (Math.abs(A.get(i) - B.get(i)) == 0) {
                winner = "D";
            } else if (Math.abs(A.get(i) - B.get(i)) == 1) {
                if (A.get(i) > B.get(i)) {
                    winner = "A";
                } else winner = "B";
            } else if (Math.abs(A.get(i) - B.get(i)) == 2) {
                if (A.get(i) > B.get(i)) {
                    winner = "B";
                } else winner = "A";
            }
            System.out.println(winner);
        }
    }
}
