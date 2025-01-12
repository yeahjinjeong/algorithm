from collections import deque
# deque의 장점
# - 엄격한 리스트
# - 속도가 list에 비해 훨씬 빠름! O(1)
# - 큐작업이 편하다! 양방향 큐!
# -- maxlen(), rotate(int), extendleft([])

queue = deque([0, 1, 2, 3, 4, 5])
queue.append(6)
value = queue.pop()
print(value) # 6
queue.appendleft(1)
value = queue.popleft()
print(value) # 1