# 큐에 좌표를 넣자!
import sys
# input = sys.stdin.readline
from collections import deque
# import heapq

n, k = map(int, input().split())
data = [[int(x) for x in input().split()] for _ in range(n)]
s, x, y = map(int, input().split())

# 상 하 좌 우
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

virus = []

for i in range(n):
    for j in range(n):
        if data[i][j] != 0:
            virus.append((data[i][j], i, j))

virus.sort()
queue = deque(virus)

# sort 때메 heap 썼다가 추가할 때마다 재정렬돼서 deque로 변경했는데, deque sort를 까먹었어서 헤맸다

def bfs():
    clock = 0
    while clock < s:
        qsize = len(queue)
        if qsize >= n*n: break
        for q in range(qsize):
            kind, r, c = queue.popleft()
            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]
                if 0 <= nr < n and 0 <= nc < n and data[nr][nc] == 0:
                    data[nr][nc] = kind
                    queue.append((kind, nr, nc))
        clock += 1
    return data[x - 1][y - 1]

print(bfs())

"""
3 3 
1 0 2
0 0 0
3 0 0
2 3 2

3 3
1 0 2
0 0 0
3 0 0
1 2 2

3 3
1 0 2
0 0 0
3 0 0
10 1 1
"""