n, m = map(int, input().split())
# 인접행렬
INF = int(1e9)
graph = [[INF] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    graph[i][i] = 0
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1
x, k = map(int, input().split())

# A는 1번 노드에 있다
for i in range(1, n+1):
    graph[1][k] = min(graph[1][k], graph[1][i] + graph[i][k])
# x부터 k까지
for i in range(1, n+1):
    graph[k][x] = min(graph[k][x], graph[k][i] + graph[i][x])

# for i in range(1, n + 1):
#     for a in range(1, n + 1):
#         for b in range(1, n + 1):
#             graph[a][b] = min(graph[a][b], graph[a][i] + graph[i][b])

result = graph[1][k] + graph[k][x]
if result >= INF :
    print(-1)
else:
    print(result)

"""
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

4 2
1 3
2 4
3 4
"""