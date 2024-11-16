package com.inflearn;

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

        musicVideo.solution(n, m, arr);
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
}
