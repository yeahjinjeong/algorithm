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
        System.out.println(maxIncomeSchedule.solution2(n, list));
    }

    /**
     * 60 3
     * 30 3
     * 50 2
     * 40 2
     * 30 1
     * 20 1
     *
     * 60 30 break;
     * 60 30
     * sum += 60;
     *
     * 50 40 break;
     * 50 40 30
     * sum += 50;
     *
     * 30 20 break;
     * 40 30 30 20
     * sum += 40;
     *
     * sum = 150;
     */

    private int solution2(int n, List<Lecture> list) {
        Collections.sort(list);

        int sum = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for (; j < n; j++) {
                if (list.get(j).duration < i) break;
                pQ.offer(list.get(j).pay);
            }
            if (!pQ.isEmpty()) sum += pQ.poll();
        }
        return sum;
    }

    /**
     * 60 3
     * 30 3
     *
     * maxPay = 60;
     * index = 0;
     *
     * 30 3
     * 50 2
     * 40 2
     *
     * maxPay = 50;
     * index = 1;
     *
     * 30 3
     * 40 2
     * 30 1
     * 20 1
     *
     * maxPay = 40;
     * index = 1;
     */

    private int solution(List<Lecture> list) {
        Collections.sort(list);

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
            sum += maxPay;
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