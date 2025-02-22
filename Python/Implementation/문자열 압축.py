def cut_string(i):
    global S
    n = i
    cut = []
    for i in range(0, len(S), n):
        cut.append(S[i:i + n])
    return cut

def solution(s):
    global S
    S = s

    length = len(S)

    for x in range(1, len(S)):
        cut = cut_string(x)
        cut.append('ㄱ')
        count = 0
        answer = ""
        for i in range(1, len(cut)):
            if cut[i - 1] != cut[i]:
                if count > 0:
                    answer += str(count + 1) + str(cut[i - 1])
                else:
                    answer += str(cut[i - 1])
                count = 0
            else:
                count += 1
        length = min(len(answer), length)
    return length

print(solution('aabbaccc'))

# import textwrap
#
# s = "abcdef"
# result = textwrap.wrap(s, 2)
# print(result)  # ['ab', 'cd', 'ef']