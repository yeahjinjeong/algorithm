S = list(map(int, input()))

count0 = 0
count1 = 0

if S[0] == 0:
    count1 += 1
else :
    count0 += 1

for i in range(1, len(S)):
    if S[i-1] != S[i]:
        if S[i] == 0:
            count1 += 1
        else :
            count0 += 1

print(min(count1, count0))