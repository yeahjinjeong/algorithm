# 정렬 알고리즘
## 선택 정렬
```
for i in range(n):
    for j in range(i+1, n):
        # arr[j]중 가장 작은 수를 arr[i]와 swap
```
## 삽입 정렬
```
for i in range(1, n):
    for j in range(i-1, 0, -1):
        # arr[j]와 arr[i]를 비교하며 swap
        # if arr[j] < arr[i] : swap
        # if arr[j] >= arr[i] : break  
```
## 퀵 정렬
### 분할정복
```
# pivot 설정
# pivot보다 작은 수 모아
# pivot보다 큰 수 모아
# quick(less) + pivot + quick(more) (재귀) 
```
## 이진 탐색
```
while start <= end:
    mid = (start+end)//2 
    # mid = int((start+end)/2)
    
    if target == arr[mid] : return arr[mid]
    if target < arr[mid] :
        end = mid - 1
    if target > arr[mid]:
        start = mid + 1
return None
```