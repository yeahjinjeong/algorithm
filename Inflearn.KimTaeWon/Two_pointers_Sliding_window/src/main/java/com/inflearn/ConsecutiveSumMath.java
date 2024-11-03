package com.inflearn;

import java.util.Scanner;

public class ConsecutiveSumMath {
    public static void main(String[] args) {
        ConsecutiveSumMath consecutiveSumMath = new ConsecutiveSumMath();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        consecutiveSumMath.solution(n);

    }

    public void solution(int n) {
        int answer = 0,cnt =1;
        n--; // 14
        while (n > 0) {
            cnt++;       // 2 // 3 // 4 // 5
            n = n - cnt; // 12 // 9 // 5 // 0
            if (n % cnt == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    // 연속된 수는
    // 몇 번 연속됐느냐를 따져서
    // 두 번 연속됐을 때 => (1+(n-1)/2) + (2+(n-1)/2)
    // = 3+(2n-2)/2 = 3+n-1 = n+2
    // => (n-2)+2
    // 세 번 연속됐을 때 => (1+(n-1)/3) + (2+(n-1)/3) + (3+(n-1)/3)
    // = 6+(3n-3)/3 = 6+n-1 = n+5
    // => (n-2-3)+5
    // 네 번 연속됐을 때 => (1+(n-1)/4) + (2+(n-1)/4) + (3+(n-1)/4) + (4+(n-1)/4)
    // = 10+(4n-4)/4 = 10+n-1 = n+9
    // => (n-2-3-4)+9
    // 다섯 번 연속됐을 때 => (1+(n-1)/5) + (2+(n-1)/5) + (3+(n-1)/5) + (4+(n-1)/5) + (5+(n-1)/5)
    // = 15+(5n-5)/5 = 15+n-1 = n+14
    // => (n-2-3-4-5)+14

    // 만약에 (n-1)/(연속 수) 로 나눠떨어지지 않으면 공식이 성립되지 않으므로 합이 같은 경우가 없다는 것을 알 수 있다
}
