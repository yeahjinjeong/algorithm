package com.inflearn;

import java.util.*;

public class Wedding {
    public static void main(String[] args) {
        Wedding wedding = new Wedding();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Attender> attenders = new ArrayList<>();
        Map<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int come  = sc.nextInt();
            int leave = sc.nextInt();
//            attenders.add(new Attender(come, leave));
            for (int j = come; j < leave; j++) {
                table.put(j, table.getOrDefault(j, 0) + 1);
            }
        }

//        Collections.sort(attenders);
//        wedding.solution(attenders);
        int answer = 0;
        for (int k : table.keySet()) {
            answer = Math.max(answer, table.get(k));
        }

        System.out.println(answer);
    }

    private void solution(List<Attender> attenders) {
    }
}

class Attender implements Comparable<Attender> {
    int come;
    int leave;

    public Attender(int come, int leave) {
        this.come = come;
        this.leave = leave;
    }

    @Override
    public int compareTo(Attender o) {
        if (this.leave == o.leave) return this.come - o.come;
        return this.leave - o.leave;
    }
}