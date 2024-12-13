package com.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaDelivery {
    static int N, M;
    static List<Point> house = new ArrayList<>();
    static List<Point> pizza = new ArrayList<>();
    static int[] combi;
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
                else if (k == 2) pizza.add(new Point(j, i));
            }
        }

        combi = new int[M];

        pizzaDelivery.DFS(0, 0);
        System.out.println(answer);
    }

    private void DFS(int L, int P) {
        if (L == M) {
            int sum = 0;
            for (Point h : house) {
                int dis = Integer.MAX_VALUE;
                for (int c : combi) {
                    dis = Math.min(dis, Math.abs(pizza.get(c).x - h.x) + Math.abs(pizza.get(c).y - h.y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = P; i < pizza.size(); i++) {
                    combi[L] = i;
                    DFS(L + 1, i + 1); // P + 1 해도 답이 나오지만, i + 1을 했을 때 시간을 줄일 수 있다!
            }
        }
    }
}
