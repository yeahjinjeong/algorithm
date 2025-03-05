# 벽 3개 세우기 => 조합 이용
# 2를 못 나오게 하는 법
from itertools import product
from itertools import combinations

n, m = map(int, input().split())
board = [[int(x) for x in input().split()] for _ in range(n)]
temp = [[0] * m for _ in range(n)]
result = 0

product_list = list(product(range(max(n, m)), repeat=2))
combination_list = list(combinations(product_list, 3))

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

def virus(r, c):
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < n and 0 <= nc < m and temp[nr][nc] == 0:
            temp[nr][nc] = 2
            virus(nr, nc)

def safe_area():
    score = 0
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                score += 1
    return score


def dfs():
    global result # list == immutable / int variable != immutable => global
    for i in range(n):
        for j in range(m):
            temp[i][j] = board[i][j]
    # 상하좌우
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 2:
                virus(i, j)
    result = max(result, safe_area())
    return

for cl in combination_list:
    (a, b), (c, d), (e, f) = cl
    if a >= n or b >= m or c >= n or d >= m or e >= n or f >= m:
        continue
    # 울타리는 빈곳에만 세우자
    if board[a][b] != 0 or board[c][d] != 0 or board[e][f] != 0:
        continue
    board[a][b] = 1
    board[c][d] = 1
    board[e][f] = 1
    dfs()
    board[a][b] = 0
    board[c][d] = 0
    board[e][f] = 0

print(result)

"""
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
"""