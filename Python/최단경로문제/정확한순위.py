n, m = map(int, input().split())
# 학생수, 비교수

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)

# 나보다 작은 것
# 내가 가지고 있는 목록보다 작은 것

def dfs(k, l):
    if graph[k]:
        for i in graph[k]:
            if i not in l:
                l.append(i)
            dfs(i, l)

for i in range(1, n + 1):
    list = []
    dfs(i, list)
    graph[i] = list

result = 0

for i in range(1, n + 1):
    count = 1 + len(graph[i]) # 나 자신 + 나보다 작은 것의 개수
    for j in range(1, n + 1):
        if i in graph[j]:
            count += 1 # + 나보다 큰 것의 개수
    if count == n: # 전체 개수와 같다면
        result += 1 # 순위를 알 수 있음!

print(result)

"""
6 6
1 5
3 4
4 2
4 6
5 2
5 4

6 6  
1 3  
2 3  
3 4  
4 5  
4 6  
5 6

6 5  
1 2  
2 3  
3 4  
4 5  
5 6
"""
