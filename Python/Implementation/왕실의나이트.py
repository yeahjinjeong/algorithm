site = input()
row = int(site[1])
col = int(ord(site[0])) - int(ord('a')) + 1

steps = [(-2, -1), (2, -1), (-2, 1), (2, 1), (1, -2), (-1, -2), (1, 2), (-1, 2)]

result = 0
for step in steps:
    nr = row + step[0]
    nc = col + step[1]
    if 1 <= nr <= 8 and 1 <= nc <= 8:
        result += 1

print(result)

# a1을 (1, 1)로 바꾸는 법
print((int(ord('a'))- int(ord('a')) + 1, 1))

# (3, 2) c2로 바꾸는 법
print(chr(3 + ord('a') - 1) + str(2))