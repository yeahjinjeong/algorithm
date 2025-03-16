from collections import deque

N, L, R = map(int, input().split())
# 각각의 땅에는 나라가 하나씩 존재
A = [[int (x) for x in input().split()] for _ in range(N)]
visit = [[0] * N] *N
# 아래, 오른쪽 비교
# 좌측상단부터 우측하단까지

dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]

result = 0

def process(r, c, index):
    united = [] # 연합 땅 리스트
    united.append((r, c))
    q = deque() # 모든 땅
    q.append((r, c))
    union[r][c] = index
    summary = A[r][c] # 인구 수
    count = 1 # 연합국 개수
    while q: # 이어진 국가가 없을 때까지
        r, c = q.popleft()
        for  i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < N and union[nr][nc] == -1: # 방문 안 했다면
                if L <= abs(A[nr][nc] - A[r][c]) <= R: # 인구 차이가 L이랑 R사이면
                    q.append((nr, nc)) # 연합가좌
                    union[nr][nc] = index # 연합 번호로 방문 표시
                    summary += A[nr][nc] # 인구 수 추가!
                    count += 1 # 연합국 개수 추가!
                    united.append((nr, nc)) # 연합 추가!
    for i, j in united: # 연합국들 좌표로 인구 수 정리
        A[i][j] = summary // count
    return count

total_count = 0

while True:
    union = [[-1] * N for _ in range(N)]
    index = 0
    for i in range(N):
        for j in range(N):
            if union[i][j] == -1:
                process(i, j, index)
                index += 1
    if index == N*N:
        break
    total_count += 1 # 인구 이동 횟수

print(total_count)

"""
2 20 50
50 30
20 40

2 40 50
50 30
20 40

2 20 50
50 30
30 40

3 5 10
10 15 20
20 30 25
40 22 10

4 10 50
10 100 20 90
80 100 60 70
70 20 30 40
50 20 100 10
"""