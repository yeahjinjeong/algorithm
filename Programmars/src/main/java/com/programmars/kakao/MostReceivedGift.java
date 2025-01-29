package com.programmars.kakao;

import java.util.*;

public class MostReceivedGift {
    public static void main(String[] args) {

        MostReceivedGift mostReceivedGift =new MostReceivedGift();
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        System.out.print(mostReceivedGift.solution(friends, gifts));
    }

    public int solution(String[] friends, String[] gifts) {

        int[][] record = createRecord(friends, gifts);

        Map<String, Integer> giftScore = createGiftScore(friends, record);


        Map<String, Integer> next = createNext(friends, record, giftScore);

        int max = 0;
        for (Integer i : next.values()) {
            max = Math.max(max, i);
        }

        return max;
    }

    private Map<String, Integer> createNext(String[] friends, int[][] record, Map<String, Integer> giftScore) {
        Map<String, Integer> next = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (record[i][j] == record[j][i]) { // 주고 받은 게 같아
                    if (giftScore.get(friends[i]) != giftScore.get(friends[j])) {
                        if (giftScore.get(friends[i]) > giftScore.get(friends[j])) {
                            next.put(friends[i], next.getOrDefault(friends[i], 0) + 1);
                        }
                    }
                } else if (record[i][j] > record[j][i]) {
                    next.put(friends[i], next.getOrDefault(friends[i], 0) + 1);
                }
            }
        }
        return next;
    }

    private Map<String, Integer> createGiftScore(String[] friends, int[][] record) {
        Map<String, Integer> giftScore = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                // i giver j taker
                giftScore.put(friends[i], giftScore.getOrDefault(friends[i], 0) + record[i][j]);
                giftScore.put(friends[j], giftScore.getOrDefault(friends[j], 0) - record[i][j]);
            }
        }
        return giftScore;
    }

    private int[][] createRecord(String[] friends, String[] gifts) {
        int[][] record = new int[friends.length][friends.length];
        for (int i = 0; i < gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i], " ");
            String giver = st.nextToken();
            String taker = st.nextToken();
            int giverIndex = 0;
            int takerIndex = 0;
            for (int j = 0; j < friends.length; j++) {
                if (friends[j].equals(giver)) {
                    giverIndex = j;
                }
                if (friends[j].equals(taker)) {
                    takerIndex = j;
                }
            }
            record[giverIndex][takerIndex] += 1;
        }
        return record;
    }

}
