package com.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {
    public static void main(String[] args) {
        MusicVideo musicVideo = new MusicVideo();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 곡의 개수
        int m = sc.nextInt(); // dvd의 개수
        // 그런데 dvd 크기는 다 같아야 하고, 노래가 잘려도 안됨!

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        musicVideo.solution2(n, m, arr);
    }

    private void solution2(int n, int m, int[] arr) {
        // 1. 범위 세팅

        int lt = arr[n - 1];
        int rt = 0;
        for (int i = 0; i < n; i++) {
            rt += arr[i];
        }

        // 2. 범위 내에서 이분검색

        // false면 커져야 하고, true면 작아져야 하고
        // 언제까지 작아져야 하는가?
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (available(n, m, arr, mid)) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        lt = Arrays.stream(arr).max().getAsInt(); // return <OptionalInt>
        rt = Arrays.stream(arr).sum(); // return <int>

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (available2(arr, mid) <= m) { // 사용되는 dvd개수가 m개보다 작거나 같으면 답이 될 수 있음
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        System.out.println(answer);
    }

    private boolean available(int n, int m, int[] arr, int mid) {
        int dvd = 0; // 용량
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            dvd += arr[i];
            if (dvd > mid) {
                cnt++;
                dvd = arr[i];
                if (cnt >= m) { // dvd 개수가 초과됐을 때 (X) 개수가 같아졌다는 것은 지금까지 3개를 채웠다는 의미이다.
                    // 더 남았다는 것은 무조건 리턴
                    return false;
                } // 해당 if문은 상위 if문 블록 바깥에 위치해도 괜찮으나, 연산 횟수를 줄이기 위해 내부에 위치시켰다.
            }
            // 정상 종료한다면 true!
        }
        return true;
    }

    private int available2(int[] arr, int mid) {
        int dvd = 0, cnt = 0;

        for (int i : arr) {
            if (dvd+i > mid) {
                cnt++;
                dvd = i;
            } else dvd += i;
        }
        return cnt;
    }

    private void solution(int n, int m, int[] arr) {
        // 일단 합계를 구하면
        // 총 45분을 3개의 DVD에
        // 그럼 한 DVD당 15분
        // 15, 13, 17 분

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int dvd = 0;
        int cnt = 1;
        int index = 0;

        while (cnt < m) {
            dvd += arr[index];
            if (dvd > sum / m) {
                dvd -= arr[index];
                cnt++;
                dvd = 0;
            } else {
                index++;
            }
        }

        int answer = 0;
        for (int i = index; i < n; i++) {
            answer += arr[i];
        }

        System.out.println(answer);
    }

    /**
     * 오답 이유 : 꼭 3개에 나눠 담아야 하는 것이 아니다!
     *  => 2개에 담는다는 것은 3개에 담을 수도 있다는 뜻이기 때문
     */

}
