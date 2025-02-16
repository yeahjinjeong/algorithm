S = list(map(int, input()))

result = S[0]

# if S[0] == 0 or S[0] == 1:
#     flag = '+'
# else:
#     flag = '*'
#
# for i in range(1, len(S)):
#     if S[i] > 1:
#         if flag == '+':
#             result += S[i]
#             flag = '*'
#         else:
#             result *= S[i]
#     elif S[i] == 1:
#         result += S[i]
#         flag = '*'
#     else:
#         flag = '+'

for i in range(1, len(S)):
    num = S[i]
    if num <= 1 or result <= 1: # result가 0이나 1인 경우는 0, 1 혹은 0, ..., 1
        result += num # 0이나 1이 앞이나 뒤에 있을 경우엔 앞에 수에 더한다
    else :
        result *= num # 0이나 1이 아니면 앞에 수에 곱한다

print(result)