n, m = map(int, input().split(" "))
weight = list(map(int, input().split(" ")))

# 1) 차례대로 선택하기
result = 0

for i in range(len(weight) - 1) :
    for j in range(i + 1, len(weight)) :
        if weight[i] != weight[j] :
          result+=1

print(result)

# 2) A가 선택 가능한 경우 * B가 선택 가능한 경우
array = [0] * (m + 1) # array[1] = 무게가 1인 공의 개수 array[m] = 무게가 m인 공의 개수

for x in weight:
    array[x] += 1

result = 0

for i in range(1, m+1):
    n -= array[i] # 전체 공의 개수 - A가 선택한 경우 = B가 선택 가능한 경우 (A와 겹치면 안되므로)
    result += array[i] * n # A의 선택 * B의 선택

print(result)