package com.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AssignMeetingRoom {
    static List<Reservation> reservations;
    static int answer, time = Integer.MIN_VALUE;
    public static void main(String[] args) {
        AssignMeetingRoom assignMeetingRoom = new AssignMeetingRoom();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        reservations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            reservations.add(new Reservation(a, b));
        }

        Collections.sort(reservations);

        assignMeetingRoom.solution();

        System.out.println(answer);
    }

    private void solution() {
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
        if this.
        return this.start - o.start;
    }
}