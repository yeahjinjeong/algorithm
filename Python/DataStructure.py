# 자료구조 : 데이터를 표현하고 관리하고 처리하기 위한 구조

# 오버플로 : 삽입시 특정한 자료구조가 수용할 수 있는 데이터의 크기를 넘어설 때 발생
# 언더플로 : 자료구조에 데이터가 전혀 들어 있지 않은 상태에서 삭제 연산을 수행하면 발생

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

# 큐
# FIFO 선입선출
from collections import deque
queue = deque()

queue.append(1)
queue.append(2)
queue.append(3)
queue.append(4)

queue.popleft()
queue.pop()

print(queue)
queue.reverse()
print(list(queue))
