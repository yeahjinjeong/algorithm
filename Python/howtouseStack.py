# queue 단방향

import queue
lifoQueue = queue.LifoQueue()
lifoQueue.put(5)
lifoQueue.put(2)
lifoQueue.put(1)
print(lifoQueue.get()) # 1
lifoQueue.put(3, 7, 9) # queue = [5, 2, 3]
print(lifoQueue.get()) # 3

