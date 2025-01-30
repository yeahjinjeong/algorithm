package com.programmars.hash;

import java.util.HashMap;
import java.util.Map;

public class FailedMarathoner {
    public static void main(String[] args) {
        FailedMarathoner failedMarathoner = new FailedMarathoner();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(failedMarathoner.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) != 0) {
                return s;
            }
        }

        return answer;
    }
}
