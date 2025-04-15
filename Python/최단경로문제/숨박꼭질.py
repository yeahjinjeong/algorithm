import heapq
import sys
input = sys.stdin.readline
INF =  int(1e9)

n, m = map(int, input().split())

start = 1

# arr = [[] * (n + 1)]
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append((b, 1))
    graph[b].append((a, 1))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        # 현재 거리가 dist 보다 크거나 같을 경우에만 반복문이 실행된다
        # 즉 현재 거리가 최단 거리가 아닌 경우
        for destination, value in graph[now]:
            cost = dist + value
            if cost < distance[destination]:
                distance[destination] = cost # 최단거리 업데이트
                heapq.heappush(q, (cost, destination))

dijkstra(start)

max_node = 0
max_distance = 0
result = []

for i in range(1, n + 1):
    if max_distance < distance[i]:
        max_node = i
        max_distance = distance[i]
        result = [max_node]
    elif max_distance == distance[i]:
        result.append(i)

print(max_node, max_distance, len(result))

"""
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
"""