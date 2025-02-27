from itertools import combinations

n, m = map(int, input().split())
# citymap = [[int(x) for x in input().split()] for _ in range(n)]
house = []
chicken = []

for i in range(n):
    data = [int(x) for x in input().split()]
    for j in range(n):
        if data[j] == 1:
            house.append((i, j))
        elif data[j] == 2:
            chicken.append((i, j))

candidates = list(combinations(chicken, m))

def get_sum(candidate):
    result = 0
    for r1, c1 in house:
        tmp = 1e9
        for r2, c2 in candidate:
            tmp = min(tmp, abs(r1 - r2) + abs(c1 - c2))
        result += tmp
    return result

result = 1e9
for candidate in candidates:
    result = min(result, get_sum(candidate))

print(result)

"""
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
"""