# 스택
# FILO 선입후출
# LIFO 후입선출

stack = []
stack.append(1)
stack.append(2)
stack.append(3)
stack.pop()
print(stack) # 최하단 원소부터 출력
print(stack[::-1]) # 최상단 원소부터 출력

import queue # queue 단방향
lifoQueue = queue.LifoQueue()
lifoQueue.put(5)
lifoQueue.put(2)
lifoQueue.put(1)
print(lifoQueue.get()) # 1
lifoQueue.put(3, 7, 9) # queue = [5, 2, 3]
print(lifoQueue.get()) # 3