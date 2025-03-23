# 답안 예시

n = int(input());

coins = [500, 100, 50, 10]

count = 0
for coin in coins:
    count += n // coin
    n %= coin

print(count)

# 내 풀이

n = int(input())

for coin in coins:
    count = 0
    while n - coin >= 0:
        n -= coin
        count += 1
    print(count)