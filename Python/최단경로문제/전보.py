# 특정 한 곳에서
# 모든 곳으로
# 모든 시간 누적!
import heapq

n, m, c = map(int, input().split())
# 인접리스트
graph = [[] for _ in range(n+1)]
for i in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((y, z))

INF = int(1e9)

distance = [INF] * (n + 1) # 최단거리테이블
q = []
visit = [False] * (n + 1)

distance[c] = 0
heapq.heappush(q, (0, c))
# visit[c] = True => ❌

while q:
    curtime, curnode = heapq.heappop(q)
    if not visit[curnode]:
        visit[curnode] = True
        for nextnode, time in graph[curnode]:
            if distance[nextnode] != min(distance[nextnode], curtime + time):
                distance[nextnode] = curtime + time
                heapq.heappush(q, (distance[nextnode], nextnode))
count = 0
max_time = 0
for i in range(n + 1):
    if distance[i] < INF:
        count += 1
        max_time = max(max_time, distance[i])

print(count-1, max_time)