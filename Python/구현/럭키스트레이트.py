S = input()

def solution(S):
    a = S[:len(S) // 2]
    b = S[len(S) // 2:]

    alist = map(int, list(a))
    blist = map(int, list(b))

    if sum(alist) == sum(blist):
        return "LUCKY"
    else:
        return "READY"

print(solution(S))