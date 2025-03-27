n, m = map(int, input().split())
INF = int(1e9)
graph = [[INF] * (n + 1) for _ in range(n + 1)]

for i in range(n + 1):
    graph[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1

for i in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][i] + graph[i][b])

result = 0
for a in range(1, n + 1):
    count = 0
    for b in range(1, n + 1):
        if graph[a][b] != INF or graph[b][a] != INF: # 나한테 화살표가 들어와 도달되거나, 나로부터 화살표가 나가서 도달하거나,
            # 연결되기만 한다면 순서를 비교할 수 있다는 뜻!
            count += 1
    if count == n: # 모든 노드와 순서를 비교할 수 있다는 뜻
        result += 1
print(result)

"""
6 6
1 5
3 4
4 2
4 6
5 2
5 4
"""