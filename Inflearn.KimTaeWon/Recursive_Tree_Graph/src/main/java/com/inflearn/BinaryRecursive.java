package com.inflearn;

import java.util.Scanner;

public class BinaryRecursive {
    public static void main(String[] args) {
        BinaryRecursive binaryRecursive = new BinaryRecursive();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        binaryRecursive.DFS(n);
    }

    private void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }
}
