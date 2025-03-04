# 최단 거리가 정확히 K인 모든 도시의 번호를 출력하는 프로그램
import sys
input = sys.stdin.readline

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
    visit[0] = True
    visit[x] = True
    queue = deque()
    queue.append((x, 0))
    while queue:
        v, level = queue.popleft()
        if level == k:
            answer.append(v)
            continue
        for i in graph[v]:
            if visit[i]:
                continue
            queue.append((i, level + 1))
            visit[i] = True
    return answer

answer = (bfs(k, x, graph))
answer.sort()
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