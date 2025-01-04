package com.inflearn;

import java.util.*;

public class SeekingMaxScore {
    static int[] dy;
    static int n,m;
    public static void main(String[] args) {
        SeekingMaxScore seekingMaxScore = new SeekingMaxScore();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        List<Problem> problems = new ArrayList<>();
        dy = new int[m + 1];

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            problems.add(new Problem(score, time));
        }

        System.out.println(seekingMaxScore.solution(problems));
    }

    private int solution(List<Problem> problems) {
        Collections.sort(problems);
        Arrays.fill(dy, 0);

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= problems.get(i).time; j--) { // 제한시간
                dy[j] = Math.max(dy[j], dy[j - problems.get(i).time] + problems.get(i).score);
            }
        }
        return dy[m];
    }
}

class Problem implements Comparable<Problem> {
    int score;
    int time;

    public Problem(int score, int time) {
        this.score = score;
        this.time = time;
    }

    @Override
    public int compareTo(Problem o) {
        return o.score - this.score;
    }
}