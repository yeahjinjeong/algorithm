package com.inflearn;

import java.util.*;

public class Wrestler {
    public static void main(String[] args) {
        Wrestler wrestler = new Wrestler();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Profile[] profiles = new Profile[n];
        List<Profile> profileList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Profile p = new Profile(sc.nextInt(), sc.nextInt());
            profiles[i] = p;
            profileList.add(p);
        }

        List<Profile> answer = wrestler.solution(n, profiles);
        System.out.println(answer.size());

        List<Profile> answer2 = wrestler.solution2(profileList);
        System.out.println(answer2.size());
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

    /**
     * Greedy Algorithm 그때 그때 최선을 선택한다
     *
     * 키와 몸무게 모두 높은 지원자가 존재하면 탈락
     * 키와 몸무게 둘 중 하나라도 나머지 지원자보다 나아야 한다
     * 키가 최상이 아니라면, 본인 보다 키 큰 지원자들보다 몸무게가 커야 한다
     * 몸무게가 최상이 아니라면, 본인보다 몸무게가 큰 지원자들보다 키가 커야 한다
     *
     * 키로 정렬했을 때
     *
     * 183 65 => 키가 나머지 지원자보다 무조건 크기 때문에 선발
     * ---------- 이 밑으로는 몸무게가 무조건 65보다는 커야 함
     * 181 60 => 탈락
     * 180 70 => 몸무게가 65보다 크기 때문에 선발
     * ---------- 이 밑으로는 몸무게가 무조건 70보다는 커야 함
     * 172 67 => 탈락
     * 170 72 => 몸무게가 70보다 크기 때문에 선발
     *
     * 몸무게로 정렬했을 때
     *
     * 170 72 => 몸무게가 나머지 지원자보다 무조건 크기 때문에 선발
     * ---------- 이 밑으로는 키가 무조건 170보다는 커야 함
     * 180 70 => 키가 크다 선발!
     * ---------- 이 밑으로는 키가 무조건 180보다는 커야 함
     * 172 67 => 탈락!
     * 183 65 => 키크다 선발
     * ---------- 이 밑으로는 키가 무조건 183보다는 커야 함
     * 181 60 => 탈락
     */

    private List<Profile> solution2(List<Profile> profileList) {
        List<Profile> answer = new ArrayList<>();

        Collections.sort(profileList);

        int max = Integer.MIN_VALUE;

        for (Profile p : profileList) {
            if (p.weight > max) {
                max = p.weight;
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
        return o.height - this.height; // 내림차순
    }
}