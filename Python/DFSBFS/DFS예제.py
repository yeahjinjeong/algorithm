def dfs(graph, v, visited): # v는 노드
    visited[v] = True
    print(v, end = ' ')
    for i in graph[v]:
        if not visited[i]: # 방문 안 했으면
            dfs(graph, i, visited) # 방문해!

graph = [
    [], # 0
    [2, 3, 8], # 1
    [1, 7], # 2
    [1, 4, 5], # 3
    [3, 5], # 4
    [3, 4], # 5
    [7], # 6
    [2, 6, 8], # 7
    [1, 7] #8
]

visited = [False] * 9

dfs(graph, 1, visited)