n, m, k = map(int, input().split())

natural = [int(a) for a in input().split()]

natural.sort()
natural.reverse()

first = natural[0]
second = natural[1]

# point = 0
# sum = 0
# current = first
# while point < m:
#     for i in range(k):
#         sum += first
#         point += 1
#     sum += second
#     point += 1
#
# print(sum)

result = (m // (k+1))*(first*k +second) + (m % (k+1))*(first)
print(result)