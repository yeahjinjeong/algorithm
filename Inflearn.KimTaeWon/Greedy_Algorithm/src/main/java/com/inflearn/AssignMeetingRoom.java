package com.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AssignMeetingRoom {
    static int answer, time = Integer.MIN_VALUE;
    public static void main(String[] args) {
        AssignMeetingRoom assignMeetingRoom = new AssignMeetingRoom();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Reservation> reservations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            reservations.add(new Reservation(a, b));
        }

        Collections.sort(reservations);

        System.out.println(assignMeetingRoom.solution(reservations, n));
    }

    private int solution(List<Reservation> reservations, int n) {
        int cnt = 0;
        int end = 0;
        for (Reservation r: reservations) {
            if (r.start >= end) {
                cnt++;
                end = r.end;
            }
        }
        return cnt;
    }

}

class Reservation implements Comparable<Reservation> {
    int start;
    int end;

    public Reservation(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Reservation o) {
        if (this.end == o.end) return this.start - o.start;
        else return this.end - o.end;
    }
}