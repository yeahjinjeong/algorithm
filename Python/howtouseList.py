a = [1, 4, 3]
print(a)
# a에 원소 2를 추가하시오
a.append(2) # O(1)
print(a) # [1, 4, 3, 2]
# a를 오름차순으로 정렬하시오
a.sort()
print(a) # [1, 2, 3, 4]
result = sorted(a)
print(result) # [1, 2, 3, 4]
# a를 내림차순으로 정렬하시오
a.sort(reverse = True)
print(a) # [4, 3, 2, 1]
result = sorted(a, reverse = True)
print(result) # [4, 3, 2, 1]
# a의 원소를 뒤집으시오
a.reverse()
print(a) # [1, 2, 3, 4]
# 2번째 인덱스에 원소 3을 추가하시오
a.insert(2, 3) # 주의! O(N)
print(a) # [1, 2, 3, 3, 4]
# 값이 3인 데이터 개수를 출력하시오
print(a.count(3)) # 2
# 값이 1인 데이터를 삭제하시오
a.remove(1) # 주의! O(N)
print(a) # [2, 3, 3, 4]

data = [('이순신', 75, 1), ('아무개', 50, 3), ('홍길동', 35, 2)]
result = sorted(data, key=lambda x:x[1])
print(result) # [('홍길동', 35, 2), ('아무개', 50, 3), ('이순신', 75, 1)]
print(data) # [('이순신', 75, 1), ('아무개', 50, 3), ('홍길동', 35, 2)]
result = sorted(data, key=lambda x:x[2])
print(result) # [('이순신', 75, 1), ('홍길동', 35, 2), ('아무개', 50, 3)]
print(data) # [('이순신', 75, 1), ('아무개', 50, 3), ('홍길동', 35, 2)]
result = sorted(data, key=lambda x:x[2], reverse= True)
print(result) # [('아무개', 50, 3), ('홍길동', 35, 2), ('이순신', 75, 1)]
print(data) # [('이순신', 75, 1), ('아무개', 50, 3), ('홍길동', 35, 2)]