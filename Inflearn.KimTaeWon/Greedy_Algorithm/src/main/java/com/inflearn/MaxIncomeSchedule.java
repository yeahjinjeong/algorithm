package com.inflearn;

import java.util.*;

public class MaxIncomeSchedule {
    static int maxDay = Integer.MIN_VALUE;
    public static void main(String[] args) {
        MaxIncomeSchedule maxIncomeSchedule = new MaxIncomeSchedule();

        Scanner sc = new Scanner(System.in);

        List<Lecture> list = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int duration = sc.nextInt();
            maxDay = Math.max(maxDay, duration);
            list.add(new Lecture(pay, duration));
        }

        System.out.println(maxIncomeSchedule.solution(list));
    }

    private int solution(List<Lecture> list) {
        Collections.sort(list);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        while (maxDay != 0) {
            int maxPay = Integer.MIN_VALUE;
            int index = 0;
            for (int i=0; i < list.size(); i++) {
                if (list.get(i).duration >= maxDay) {
                    if (list.get(i).pay == Math.max(maxPay, list.get(i).pay)) {
                        maxPay = list.get(i).pay;
                        index = i;
                    }
                }
            }
            sum += list.get(index).pay;
            list.remove(index);
            maxDay--;
        }
        return sum;
    }
}

class Lecture implements Comparable<Lecture> {
    int pay;
    int duration;

    public Lecture(int pay, int duration) {
        this.pay = pay;
        this.duration = duration;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.duration - this.duration;
    }
}
/**
 * 60 3
 * 30 3
 * 50 2
 * 40 2
 * 30 1
 * 20 1
 */