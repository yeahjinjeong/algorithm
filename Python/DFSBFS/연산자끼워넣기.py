n = int(input())
data = list(map(int, input().split())) # 연산 데이터
add, sub, mul, div = map(int, input().split()) # 연산자의 개수


min_value = 1e9
max_value = -1e9

# 연산자 우선순위를 무시, 앞에서부터 진행
# 나눗셈은 정수 나눗셈으로 몫만
# 음수를 양수로 나눌 때는 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼다

def dfs(L, now):
    global min_value, max_value, add, sub, mul, div
    if L == n:
        min_value = min(min_value, now)
        max_value = max(max_value, now)
    else:
        if add > 0:
            add -= 1
            dfs(L + 1,  now + data[L]) # + 가 맨 처음에 오는 경우 시작
            add += 1
        if sub > 0:
            sub -= 1
            dfs(L + 1, now - data[L])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(L + 1, now * data[L])
            mul += 1
        if div > 0:
            div -= 1
            dfs(L + 1, int(now / data[L])) # 나눌 때는 나머지를 제거
            div += 1

dfs(1, data[0])

print(max_value)
print(min_value)