# deque의 장점
# - 엄격한 리스트
# - 속도가 list에 비해 훨씬 빠름! O(1)
# - 큐작업이 편하다! 양방향 큐!
# -- maxlen(), rotate(int), extendleft([])

from collections import deque
queue = deque([0, 1, 2, 3, 4, 5])
queue.append(6)
value = queue.pop()
print(value) # 6
queue.appendleft(1)
value = queue.popleft()
print(value) # 1

# list 사용

list = []
list.append(10)
for i in range(10):
    list.append(i)

list = [11] + list
list = list + [12]

print(list.pop()) # 12
print(list.pop(0)) # 11 (index pop 가능)

# queue 모듈 사용

import queue
priorityQueue = queue.PriorityQueue()
priorityQueue.put(2, 1, 3) # 맨 첫 요소만 큐에 들어감~
print(priorityQueue.get()) # 2
print(priorityQueue.qsize()) # 0

priorityQueue.put(2)
priorityQueue.put(1)
priorityQueue.put(3)
print(priorityQueue.get()) # 1 # 가장 작은 요소! (오름차순)