package com.programmars.kakao;

public class MountainTile {
    static int[][] board;
    static int N, answer;

    public static void main(String[] args) {
        MountainTile mountainTile = new MountainTile();
        int[] tops = {1, 1, 0, 1};
        int solution = mountainTile.solution(4, tops);
        System.out.print(solution);
        System.out.println(solution2(4, tops));
    }

    public int solution(int n, int[] tops) {
        N = n + n + 1;
        board = new int[2][N + 1]; // index 1부터 사용

        for (int i = 1; i < tops.length + 1; i++) {
            board[0][i*2] = tops[i - 1];
            // 2에 0 넣고, 4에 1 넣고, 6에 2 넣고, 8에 3 넣고 ...
        }
        for (int i = 1; i < N + 1; i++) {
            board[1][i] = 1;
        }
        DFS(1);
        return answer % 10007;
    }

    private void DFS(int L) {
        if (L == N) {
            answer += 1;
        } else {
            // 정삼각형
            if (board[1][L] == 1) {
                board[1][L] = -1;
                DFS(L + 1);
                board[1][L] = 1;
            }
            // 다이아몬드
            if (board[0][L] == 1 && board[1][L] == 1) {
                board[0][L] = -1;
                board[1][L] = -1;
                DFS(L + 1);
                board[0][L] = 1;
                board[1][L] = 1;
                DFS(L + 1);
            }
            // 옆으로
            if (L < N && board[1][L] == 1 && board[1][L + 1] == 1) {
                board[1][L] = -1;
                board[1][L + 1] = -1;
                DFS(L + 1);
                board[1][L] = 1;
                board[1][L + 1] = 1;
                DFS(L + 1);
            }
        }
    }

    public static int solution2(int n, int[] tops) {
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        a[1] = 1;
        if (tops[0] == 1) b[1] = 3;
        else b[1] = 2;

        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 1] + b[i - 1]) % 10007;
            if (tops[i - 1] == 1) {
                b[i] = (a[i - 1] * 2 + b[i - 1] * 3) % 10007;
            } else {
                b[i] = (a[i - 1] + b[i - 1] * 2) % 10007;
            }
        }
        return (a[n] + b[n]) % 10007;
    }
}
