from functools import cmp_to_key

'''
numbers	return
[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]	"9534330"
'''

def compare(x, y):
    if x + y > y + x:
        return -1
    elif x + y < y + x:
        return 1
    else:
        return 0

def solution(numbers):
    numbers = list(map(str, numbers))  # int -> str
    numbers.sort(key=cmp_to_key(compare))

    return str(int("".join(numbers)))  # 불필요한 0을 제거하기 위해 int로 변환 후 str로 재변환한다.

'''
6, 10 비교
610 > 106 return -1 => 6, 10
10, 2 비교
102 < 210 return 1 => 2, 10
6 2 10

3, 30 비교
330 > 303 return -1 => 3, 30
30, 34 비교
3034 < 3430 return 1 => 34, 30
3, 34 비교
334 < 343 retun 1 => 34, 3
34, 3, 30

30, 5 비교 
305 < 530 return 1 => 5, 30
3, 5 비교
35 < 53 return 1 => 5, 3
34, 5 비교
345 < 534 return 1 => 5, 34

5, 34, 3, 30

30, 9 비교
309 < 930 return 1 => 9, 30
3, 9 비교
39 < 93 return 1 => 9, 3
34, 9 비교
349 < 934 return 1 => 9, 34
5, 9 비교
59 < 95 return 1 => 9, 5

9, 5, 34, 3, 30

'''