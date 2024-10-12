package org.example;

import java.util.*;

public class ReverseCharacters {
    public static void main(String[] args) {
        ReverseCharacters reverseCharacters = new ReverseCharacters();

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String result = reverseCharacters.solution(input);
        System.out.println(result);
    }

    public String solution(String str) {
        int lt = 0, rt = str.length() - 1;
        char[] chars = str.toCharArray();
//        while (lt < rt) {
//            if ((chars[lt] >= 65 && chars[lt] < 90 || chars[lt] >= 97 && chars[lt] < 122) &&
//                    (chars[rt] >= 65 && chars[rt] < 90 || chars[rt] >= 97 && chars[rt] < 122)) {
//                char tmp = chars[lt];
//                chars[lt] = chars[rt];
//                chars[rt] = tmp;
//            }
//            lt ++;
//            rt --;
//        }

        // adkj$dfkj@
        // ajkf$djkd@

        // -> 오답 !

        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) lt++;
            else if (!Character.isAlphabetic(chars[rt])) rt--;
            else { // 둘 다 알파벳이면 바꿔!
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt ++;
                rt --;
            }
        }

        // adkj$dfkj@
        // jkfd$jkda@

        // fd#afj!@kd$f%w&
        // wf#dkj!@fa$d%f&

        return String.valueOf(chars);
    }
}
