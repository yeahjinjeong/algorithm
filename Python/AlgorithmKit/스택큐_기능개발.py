def solution(progresses, speeds):
    answer = []
    while progresses:
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
        sum = 0
        while progresses and progresses[0] >= 100:
            sum += 1
            progresses.pop(0)
            speeds.pop(0)
        if sum > 0:
            answer.append(sum)
    return answer