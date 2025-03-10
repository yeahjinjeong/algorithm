# 재귀함수 구현에 더  가까운 문제입니다

# 균형잡힌 문자열
def balanced_index(p):
    count = 0
    for i in range(len(p)):
        if p[i] == '(':
            count+=1
        else:
            count -= 1
        # ( 개수와 ) 의 개수를 센다
        # count 증감을 통해 메모리를 최소화한다
        if count == 0:
            return i # 완벽 닫혔을 때의 인덱스 반환

def check_proper(p):
    count = 0
    for i in p:
        if i == '(':
            count += 1
        else:
            if count == 0:
                return False # ( 보다 )이 먼저 나오는 순간 False반환
            count -= 1
    return True

def solution(p):
    answer = ''
    if p == '':
        return answer
    # p가 공백이 아니면
    index = balanced_index(p) # 완벽 닫혔을 때의 인덱스
    u = p[:index +1] # 검증 완료된 문자열
    v = p[index +1:] # 검증 전 문자열

    if check_proper(u): # 순서가 잘 되어 있다면
        answer = u + solution(v) # 정답에 그대로 추가 ( 뒤에 검증 안 된 건 다시 solution 재귀로 검사 드간다)
    else: # 만약 u = ))(( v = () 이다
        answer = '('
        answer += solution(v) # 어차피 여기엔 다 완벽히 바뀐 것들만 추가 될거야
        answer += ')' # (())
        u = list(u[1:-1]) # )(
        for i in range(len(u)): # 0~4
            if u[i] == '(':
                u[i] = ')'
            else:
                u[i] = '('
            # ()
        answer += "".join(u) # (())()
    return answer

# 이건 왜 안돼?

def solution2(p):
    answer = ''
    if p == '':
        return answer
    # p가 공백이 아니면
    index = balanced_index(p) # 완벽 닫혔을 때의 인덱스
    u = p[:index +1] # 검증 완료된 문자열
    v = p[index +1:] # 검증 전 문자열

    if check_proper(u): # 순서가 잘 되어 있다면
        answer = u + solution(v) # 정답에 그대로 추가 ( 뒤에 검증 안 된 건 다시 solution 재귀로 검사 드간다)
    else: # 만약 u = ))(( v = () 이다
        for i in range(len(u)): # 0~4
            if u[i] == '(':
                u[i] = ')'
            else:
                u[i] = '('
            # ()
        answer += "".join(u) # (())()
        answer += solution(v)
    return answer

print(solution("()))((()"))
print(solution2("()))((()"))