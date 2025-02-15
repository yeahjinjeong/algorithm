S = list(map(int, input()))

result = S[0]
if S[0] == 0 or S[0] == 1:
    flag = '+'
else:
    flag = '*'

for i in range(1, len(S)):
    if S[i] > 1:
        if flag == '+':
            result += S[i]
            flag = '*'
        else:
            result *= S[i]
    elif S[i] == 1:
        result += S[i]
        flag = '*'
    else:
        flag = '+'

print(result)