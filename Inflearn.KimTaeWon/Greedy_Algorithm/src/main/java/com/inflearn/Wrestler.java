package com.inflearn;

import java.util.*;

public class Wrestler {
    public static void main(String[] args) {
        Wrestler wrestler = new Wrestler();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Profile[] profiles = new Profile[n];

        for (int i = 0; i < n; i++) {
            Profile p = new Profile(sc.nextInt(), sc.nextInt());
            profiles[i] = p;
        }

        List<Profile> answer = wrestler.solution(n, profiles);
        System.out.println(answer.size());

    }

    private List<Profile> solution(int n, Profile[] profiles) {
        List<Profile> answer = new ArrayList<>();

        for (Profile p : profiles) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (p != profiles[i]) {
                    if (p.height <= profiles[i].height && p.weight <= profiles[i].weight) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                answer.add(p);
            }
        }
        return answer;
    }

}

class Profile implements Comparable<Profile> {
    int height;
    int weight;

    public Profile(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Profile o) {
        return o.height - this.height;
    }
}