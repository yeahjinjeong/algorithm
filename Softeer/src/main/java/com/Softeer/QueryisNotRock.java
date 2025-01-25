package com.Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QueryisNotRock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken()) - 1;
            String third = st.nextToken();
            if (first == 2) {
                checkRock(S, second, Integer.parseInt(third) - 1);
            } else {
                S = S.replace(S.charAt(second), third.charAt(0));
            }
        }

    }

    private static void checkRock(String s, int l, int r) {
        String newS = s.substring(l, r + 1);
        int sum = DFS(newS, 0, "");
        System.out.println(sum);
    }

    private static int DFS(String newS, int i, String s) {
        int sum = 0;
        if (i == newS.length()) {
            if (s.contains("ROCK")) return 1;
        } else {
            sum += DFS(newS, i + 1, s);
            sum += DFS(newS, i + 1, s + newS.charAt(i));
        }
        return sum;
    }
}
/*
6
NAROCK
3
2 1 6
1 3 C
2 2 5

6
RRROCK
3
2 3 6
2 2 6
2 1 6
 */