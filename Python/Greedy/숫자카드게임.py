n, m = map(int, input().split())

# min = 10000 # min이 변수로 덮어쓰였을 때 내장 함수 min()을 사용할 수 없으니 주의해야 한다
# max = 0
board = [[int(x) for x in input().split(" ")] * 1 for _ in range(n)]

# for i in range(n):
#     for j in range(m):
#         if board[i][j] < min:
#             min = board[i][j]
#     if (max < min):
#         max = min
#     min = 10000
#
# print(max)

max_value = 0

for i in range(n):
    min_value = min(board[i])
    max_value = max(max_value, min_value)

print(max_value)