def solution(n, lost, reserve):
    # 여벌 체육복을 가져왔지만 도난당한 학생 정리
    # 즉, reserve 리스트에 있으나, lost 리스트에도 있다.

    print("set(lost):", set(lost))
    print("set(reserve):", set(reserve))

    lost_set = set(lost) - set(reserve)
    print("set(lost_set):", set(lost_set))

    reserve_set = set(reserve) - set(lost)
    print("set(reserve_set):", set(reserve_set))

    for r in reserve_set:
        if r - 1 in lost_set:
            lost_set.remove(r - 1)
        elif r + 1 in lost_set:
            lost_set.remove(r + 1)

    return n - len(lost_set)

print(solution(5, [2,4], [1,3,5]))
print(solution(5, [2,4], [3]))
print(solution(3, [3], [1]))
