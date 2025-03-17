import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
start = int(input())
graph = [[] for _ in range(n+1)] # 인접리스트
visited = [False] * (n+1)
distance = [INF] * (n+1) # 최단거리 테이블

for _ in range(11):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

q = []
# 일단 start 노드에서 갈 수 있는 노드들을 찾아서 최단거리 테이블을 업데이트 해보자
heapq.heappush(q, (0, start))
distance[start] = 0

# 최단거리 테이블에서 가장 최단인 노드 선택!
# 만약 거리가 같다면, 더 적은 인덱스 선택
# def find_shortest():
#     global visited, distance
#     min_value = INF
#     min_node = start
#     for i in range(1, n + 1):
#         if distance[i] < min_value and not visited[i]:
#             min_value = distance[i]
#             min_node = i
#     return min_node

while q: # 이 부분이 교재와 다름
    cur_cost, cur_node = heapq.heappop(q)
    if visited[cur_node]: continue
    visited[cur_node] = True
    for arrived_node, cost in graph[cur_node]:
        distance[arrived_node] = min(distance[arrived_node], cost + cur_cost)
        heapq.heappush(q, (cost + cur_cost, arrived_node))

for i in range(1, n+1):
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])

"""
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
"""