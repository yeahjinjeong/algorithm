def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    time = 0
    while True:
        index = time % len(food_times)
        if food_times[index] != 0:
            food_times[index] -= 1
            time += 1
            k -= 1
        else:
            time += 1
        if k == -1:
            break

    answer = index + 1

    return answer

# test cases are all passed but bad efficiency
import heapq # 우선순위 큐

def solution2(food_times, k):
    # if sum(food_times) <= k:
    #     return -1
    q = []
    # heapq.heappush(q, (8, 1))
    # heapq.heappush(q, (6, 2))
    # heapq.heappush(q, (4, 3))
    for i in range(len(food_times)) :
        heapq.heappush(q, (food_times[i], i + 1))

    # print(q[0]) # (4, 3)
    # print(q[0][0]) # 4

    time = 0 # 몇초가 흘렀나?
    previous = 0 # 직전 음식이 몇초짜리였는가
    leftover = len(food_times)

    while len(q)>0 and time + (q[0][0] - previous)*leftover <= k:
        now = heapq.heappop(q)[0]
        time += (now - previous)*leftover
        leftover-=1
        previous = now

    result = sorted(q, key = lambda x:x[1])
    if len(result) == 0: return -1
    return result[(k - time)%leftover][1] # 남은 초 = rotate 횟수

print(solution([8, 6, 4], 15))
print(solution2([8, 6, 4], 15))