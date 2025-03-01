from collections import deque

n, m = map(int, input().split())
board = [[int(x) for x in input()] for _ in range(n)]
visit = [[False] * m for _ in range(n)]

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

def bfs(board, i, j, visit):
    level = 0
    queue = deque()
    queue.append((i, j, 0))
    visit[i][j] = True
    while queue:
        r, c, level = queue.popleft()
        for d in range(4):
            nr = r + dy[d]
            nc = c + dx[d]
            if nr == n - 1 and nc == m - 1:
                return level + 1
            if 0 <= nr < n and 0 <= nc < m and board[nr][nc] == 1 and visit[nr][nc] == False:
                queue.append((nr, nc, level+1))
                visit[nr][nc] = True
    return -1

print(bfs(board, 0, 0, visit))

"""
5 6
101010
111111
000001
111111
111111
"""