# 최단 거리가 정확히 K인 모든 도시의 번호를 출력하는 프로그램

# BFS
from collections import deque

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for i in range(m):
    s, a = map(int, input().split())
    graph[s].append(a)

def bfs(k, x, graph):
    answer = []
    visit = [False] * len(graph)
    queue = deque()
    for i in graph[x]:
        queue.append((i, 1))
        visit[i] = True
    while queue and not all(visit):
        v, level = queue.popleft()
        if level == k:
           answer.append(v)
        for j in graph[v]:
            if not visit[j]:
                queue.append((j, level + 1))
                visit[j] = True
    return answer

answer = (bfs(k, x, graph))
if len(answer)>0:
    for i in answer:
        print(i)
else:
    print(-1)

"""
4 4 2 1
1 2
1 3
2 3
2 4
"""
"""
4 3 2 1
1 2
1 3
1 4
"""
"""
4 4 1 1
1 2
1 3
2 3
2 4
"""