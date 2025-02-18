def solution(food_times, k):
    answer = 0
    time = 0
    index = 0
    while True:
        if all(x == 0 for x in food_times):
            return -1
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