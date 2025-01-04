package com.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class ExchangingCoin {
    static int[] dy;
    public static void main(String[] args) {
        ExchangingCoin exchangingCoin = new ExchangingCoin();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        dy = new int[m + 1];

        System.out.println(exchangingCoin.solution(coin, m));
    }

    private int solution(int[] coin, int m) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        return dy[m];
    }
}

/*
dy 배열에 주어진 동전을 이용해서 만들 수 있는 최소 동전의 개수를 저장한다
1원은 1원 한 개
2원은 1원 두 개를 쓰는 방법, 2원 한 개를 쓰는 방법 두가지가 있으나, 2원 한 개 쓰는 게 최소이므로 1 저장
3원은 1원 세 개를 쓰는 방법, 1 + 2 이렇게 두 개를 쓰는 방법 중 두 개 쓰는 게 최소이므로 2 저장
4원은 1원 네 개를 쓰는 방법, 2원 두개를 쓰는 방법 중 2원 두 개 쓰는 게 최소 => 2 저장

dy[j - coin[i]] + 1

- 1원으로 만든다면?
dy[1] = dy[1 - 1] + 1 = dy[0] + 1 = 0 + 1 = 1;
dy[2] = dy[2 - 1] + 1 = dy[1] + 1 = 1 + 1 = 2;
dy[3] = dy[3 - 1] + 1 = dy[2] + 1 = 2 + 1 = 3;
dy[4] = 4;
dy[5] = 5;
dy[6] = 6;
...
- 2원으로 만든다면?
dy[2] = dy[2 - 2] + 1 = dy[0] + 1 = 0 + 1 = 1; (1 < 2 => 1 저장)
dy[3] = dy[3 - 2] + 1 = dy[1] + 1 = 1 + 1 = 2; (2 < 3 => 2 저장)
dy[4] = dy[4 - 2] + 1 = dy[2] + 1 = 1 + 1 = 2; (2 < 4 => 2 저장)
dy[5] = dy[5 - 2] + 1 = dy[3] + 1 = 2 + 1 = 3;
dy[6] = dy[6 - 2] + 1 = dy[4] + 1 = 2 + 1 = 3;
- 5원으로 만든다면?
dy[5] = dy[5 - 5] + 1 = 1; (1 저장)
dy[6] = dy[6 - 5] + 1 = dy[1] + 1 = 2;  (2 저장)

나머지가 연속적으로 저장된다 ?!
- 2원
dy[6] = dy[4] + 1 = (dy[2] + 1) + 1 = ((dy[0] + 1) + 1) + 1 = 0 + 1 + 1 + 1 = 3;
- 5원
dy[6] = dy[1] + 1 = (dy[0] + 1) + 1 = 2;
...
dy[14] = dy[9] + 1 = (dy[4] + 1) + 1 => 5원으로는 dy[5]부터 초기화됐을테니까 dy[4]는 2원으로 초기화된 게 최소였겠지. dy[4] = dy[2] + 1 = (dy[0] + 1) + 1;
                    = 2 + 1 + 1 = 4; => 5원 2개 + 2원 2개 => 4개
dy[15] = dy[10] + 1 = (dy[5] + 1) + 1 = ((dy[0] + 1) + 1) + 1 = 3;
 */