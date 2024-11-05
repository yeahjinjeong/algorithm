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
    // 두 번 연속됐을 때 => (1+(n-3)/2) + (2+(n-3)/2)
    // = 3+(2n-6)/2 = 3+n-3 = n
    // 세 번 연속됐을 때 => (1+(n-6)/3) + (2+(n-6)/3) + (3+(n-6)/3)
    // = 6+(3n-18)/3 = 6+n-6 = n
    // 네 번 연속됐을 때 => (1+(n-10)/4) + (2+(n-10)/4) + (3+(n-10)/4) + (4+(n-10)/4)
    // = 10+(4n-40)/4 = 10+n-10 = n
    // 다섯 번 연속됐을 때 => (1+(n-15)/5) + (2+(n-15)/5) + (3+(n-15)/5) + (4+(n-15)/5) + (5+(n-15)/5)
    // = 15+(5n-75)/5 = 15+n-15 = n

    // 만약에 {n-(1+2+3+...연속 수만큼 더해짐)}/(연속 수) 로 나눠떨어지지 않으면 공식이 성립되지 않으므로 합이 같은 경우가 없다는 것을 알 수 있다
}
