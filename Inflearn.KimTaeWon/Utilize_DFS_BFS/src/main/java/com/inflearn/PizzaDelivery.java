package com.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaDelivery {
    static int N, M;
    static List<Point> house = new ArrayList<>();
    static List<Point> pizza = new ArrayList<>();
    static int[] visit;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        PizzaDelivery pizzaDelivery = new PizzaDelivery();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = sc.nextInt();
                if (k == 1) house.add(new Point(j, i));
                if (k == 2) pizza.add(new Point(j, i));
            }
        }

        visit = new int[pizza.size()];
        Point[] arr = new Point[M];

        pizzaDelivery.DFS(0, arr);
        System.out.println(answer);
    }

    private void DFS(int L, Point[] arr) {
        if (L == M) {
            int sum = 0;
            for (Point p : house) {
                int dis = Integer.MAX_VALUE;
                for (Point a : arr) {
                    dis = Math.min(dis, Math.abs(a.x - p.x) + Math.abs(a.y - p.y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = 0; i < pizza.size(); i++) {
                if (visit[i] == 0) {
                    visit[i] = 1;
                    arr[L] = pizza.get(i);
                    DFS(L + 1, arr);
                    visit[i] = 0;
                }
            }
        }
    }
}
