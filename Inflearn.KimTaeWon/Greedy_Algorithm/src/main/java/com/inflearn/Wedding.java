package com.inflearn;

import java.util.*;

public class Wedding {
    public static void main(String[] args) {
        Wedding wedding = new Wedding();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Time> times = new ArrayList<>();
        Map<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int come  = sc.nextInt();
            int leave = sc.nextInt();
            times.add(new Time(come, 'c'));
            times.add(new Time(leave, 'l'));
//            for (int j = come; j < leave; j++) {
//                table.put(j, table.getOrDefault(j, 0) + 1);
//            }
        }

        System.out.println(wedding.solution(times));

//        int answer = 0;
//        for (int k : table.keySet()) {
//            answer = Math.max(answer, table.get(k));
//        }
//        System.out.println(answer);
    }

    private int solution(List<Time> times) {
        Collections.sort(times);

        int cnt = 0;
        int answer = Integer.MIN_VALUE;

        for (Time a : times) {
            if (a.state == 'c') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}

class Time implements Comparable<Time> { // 사람 기준이 아닌, 시간 기준!
    int time;
    char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        if (this.time == o.time) return o.state - this.state; // l이 c보다 먼저오도록! 같은 14시인데 떠나는 사람과 온 사람이 있을 때
        // 떠나는 사람이 먼저 온 사람이므로
        // 먼저 온 사람 것을 먼저 처리해준다
        // 만약 온 사람 것을 먼저 처리한다면, 이미 떠난 사람을 -(마이너스) 하기 전에 +(플러스) 먼저 계산돼서 over된다.
        return this.time - o.time;
    }
}