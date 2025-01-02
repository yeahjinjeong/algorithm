package com.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheHighestTower {
    static int[] dy;
    public static void main(String[] args) {
        TheHighestTower theHighestTower = new TheHighestTower();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dy = new int[n];

        List<Tower> towers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            towers.add(new Tower(area, height, weight));
        }

        System.out.println(theHighestTower.solution(towers));
    }

    private int solution(List<Tower> towers) {
        Collections.sort(towers);

        int answer;

        dy[0] = towers.get(0).height;
        answer = dy[0];
        for (int i = 1; i < towers.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (towers.get(j).area > towers.get(i).area && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + towers.get(i).height;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
}

class Tower implements Comparable<Tower> {
    int area;
    int height;
    int weight;

    public Tower(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Tower o) {
        if (this.weight == o.weight) return o.area - this.area;
        return o.weight - this.weight;
    }
}