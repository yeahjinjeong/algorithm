from itertools import permutations, combinations, combinations_with_replacement

data = ['A', 'B', 'C']
result = list(permutations(data, 3)) # 순서 O 중복 O
print(result) # [('A', 'B', 'C'), ('A', 'C', 'B'), ('B', 'A', 'C'), ('B', 'C', 'A'), ('C', 'A', 'B'), ('C', 'B', 'A')]
result = list(permutations(data, 2)) # ex) ('A', 'B') =/= ('B', 'A')
print(result) # [('A', 'B'), ('A', 'C'), ('B', 'A'), ('B', 'C'), ('C', 'A'), ('C', 'B')]
result = list(combinations(data, 3)) # 순서 X 중복 X
print(result) # [('A', 'B', 'C')]
result = list(combinations(data, 2)) # ex) ('A', 'B') = ('B', 'A')
print(result) # [('A', 'B'), ('A', 'C'), ('B', 'C')]
result = list(combinations_with_replacement(data, 2)) # 순서 X 중복 O
print(result) # [('A', 'A'), ('A', 'B'), ('A', 'C'), ('B', 'B'), ('B', 'C'), ('C', 'C')]

# list()와 []의 차이
# [('A', 'B', 'C')]
# [<itertools.combinations object at 0x000002C4C942D850>]