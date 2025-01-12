# 우선 input()은 무조건 str으로 들어옴!

# 1. 공백 없이 여러 값 입력
basic_list = list(input())
print(basic_list)

# 2. 공백 포함 여러 값 입력
str_list = input().split()
print(str_list)

# 3. map(fun/type, data)
num_list = list(map(int, input().split()))
print(num_list)

# 4. 숫자 쪼개 저장하기
n, m = map(int, input().split())
print(n)
print(m)

# 5.
M, N = map(int, input().split(" "))
board = [[int(n) for n in input().split(" ")] for _ in range(N)]
# [int(n) for n in some_list] some_list의 모든 값을 int타입으로 매핑해서 리스트로 만들어주는 문법
# [[] for _ in range(N)] : 빈구조를 N개 가짐


# 6. 빠른 입력 받기
import sys
data = sys.stdin.readline().rstrip()
print(data)

# ++ 반복문
# - list의 값 인덱스로 가져오기
# 1) while
i = 0
while (i < len(str_list)) :
    print(str_list[i])
    i += 1
# 2) for
for i in range(0, len(basic_list)) :
    # print(list[i])
    print(int(basic_list[i]))

# 상하좌우 이동
D = [(0, 1), (1, 0), (0, -1), (-1, 0)]
curRow = 0;
curCol = 0;
for i, j in D:
    print(i, j)
    nextRow = curRow + i
    nextCol = curCol + j
    print(nextRow, nextCol)