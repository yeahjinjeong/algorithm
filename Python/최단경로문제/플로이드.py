# 100개의 도시 중 한 도시에서 출발 -> 다른 도시에 도착하는 10만개의 버스
# 모든 도시의 쌍에 대해서 필요한 비용의 최솟값!!

n = int(input())
m = int(input())

INF = int(1e9)
graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(n + 1):
    graph[i][i] = 0

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

for i in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][i] + graph[i][b])

for i in range(1,  n + 1):
    for j in range(1, n + 1):
        if graph[i][j] >= INF:
            print(0, end=' ')
        else: print(graph[i][j], end=' ')
    print()

"""
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
"""