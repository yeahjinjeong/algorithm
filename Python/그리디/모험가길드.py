n = int(input())
adventurer = [int(x) for x in input().split(" ")]

adventurer.sort()

# 오름차순 풀이
group = 0
count = 0

for i in adventurer:
    count += 1
    if count >= i:
        group += 1
        count = 0

print(group)

# 내림차순 풀이
adventurer.reverse()

group = 0
i = 0
while i < len(adventurer) :
    i = i + adventurer[i]
    if i <= len(adventurer) :
        group+=1

print(group)