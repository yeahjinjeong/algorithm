package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SummaryString {
    public static void main(String[] args) {
        SummaryString summaryString = new SummaryString();

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        summaryString.solution(input);
    }

    public void solution(String str) {
        // Map으로 풀려고 했으나 '연속' 조건 때문에 보류
        str += " ";
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char pre = str.charAt(0);
        int sum = 0;
        for (char c : chars) {
            if (c == pre) {
                sum ++;
            } else {
                sb.append(pre); // 직전 문자만 추가하고 마지막 문자는 추가되지 않음
                if (sum > 1) {
                    sb.append(sum);
                }
                pre = c;
                sum = 1;
            }
        }
        System.out.println(sb.toString());
    }
}
