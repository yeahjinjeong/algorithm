n, m = map(int, input().split())
r, c, d = map(int, input().split())
board = [[int(x) for x in input().split()] for _ in range(n)]
# 북 동 남 서
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
count = 0
while True:
    flag = False
    for i in range(4):
        d = (d - 1) % 4  # 방향 회전!
        nr = r + dy[d]
        nc = c + dx[d]
        # if nr < 0 or nr >= n or nc < 0 or nc >= m:
        #     continue
        if board[nr][nc] == 0:
            r = nr
            c = nc
            count += 1
            board[nr][nc] = -1
            flag = True
            break
    if not flag:
        nr = r - dy[d]
        nc = c - dx[d]
        if board[nr][nc] == 1:
            break
        else:
            r = nr
            c = nc
print(count)
# 4 4
# 1 1 0
# 1 1 1 1
# 1 0 0 1
# 1 1 0 1
# 1 1 1 1

# print(-1 // 4) # -1
# print(-1 / 4) # -0.25