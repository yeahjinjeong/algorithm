package com.inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Emergency {
    public static void main(String[] args) {
        Emergency emergency = new Emergency();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] waiting = new int[n];
        for (int i = 0; i < n; i++) {
            waiting[i] = sc.nextInt();
        }

        emergency.solution(n, m, waiting);
    }

    private void solution(int n, int m, int[] waiting) {
        Queue<Patient> queue = new LinkedList<>();

        int id = 0;
        for (int i :waiting) {
            queue.add(new Patient(id, i));
            id++;
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            Patient tmp = queue.poll();
            for (Patient p : queue) {
                if (p.getPriority() > tmp.getPriority()) {
                    queue.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.getId() == m) System.out.print(answer);
            }
        }
    }
}

class Patient {
    private int id;
    private int priority;

    public Patient(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}