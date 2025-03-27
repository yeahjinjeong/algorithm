import heapq

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
INF = int(1e9)

def test_case():
    n = int(input())
    graph = [[int(x) for x in input().split()] for _ in range(n)]
    distance = [[INF] * n for _ in range(n)]
    q = []
    heapq.heappush(q, (graph[0][0], 0, 0))
    while q:
        cost, cx, cy = heapq.heappop(q)
        if distance[cx][cy] < cost: # 이미 더 최단거리로 업데이트 되었음!
            continue
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if distance[nx][ny] > graph[nx][ny] + cost:
                    distance[nx][ny] = graph[nx][ny] + cost
                    heapq.heappush(q, (distance[nx][ny], nx, ny))
    print(distance[n-1][n-1])

t = int(input())

for _ in range(t):
    test_case()

"""
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
"""