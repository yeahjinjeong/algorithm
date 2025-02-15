S = list(map(int, input()))

result = 0
flag = '+'
for i in S:
    if i != 0:
        if flag == '+':
            result += i
            flag = '*'
        else:
            result *= i
    else:
        flag = '+'

print(result)