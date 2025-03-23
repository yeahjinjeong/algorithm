lock_size, key_size = map(int, input().split())
lock = [[int(x) for x in input().split()] for _ in range(lock_size)]
key = [[int(x) for x in input().split()] for _ in range(key_size)]

"""
3 3
1 1 1
1 1 0
1 0 1
0 0 0
1 0 0
0 1 1
"""

key_size = len(key)
lock_size = len(lock)
# 2차원 배열 90도 회전시키기
def rotate(key):
    key_size = len(key)
    new_key = [[0] * key_size for _ in range(key_size)]
    k = 0
    for i in range(key_size):
        for j in range(key_size - 1, -1, -1):
            new_key[i][k % key_size] = key[j][i]
            k += 1
    return new_key

# lock 중앙에 위치 시키기
def make_big_lock(lock):
    global key_size
    lock_size = len(lock)
    new_n = lock_size + (key_size - 1) * 2
    big_lock = [[0]* new_n for _ in range(new_n)]
    # leftTop = new_n // lock_size
    leftTop = (key_size - 1)
    for i in range(lock_size):
        for j in range(lock_size):
            big_lock[i + leftTop][j + leftTop] = lock[i][j]
    return big_lock

# 자물쇠의 중간 부분이 모두 1인지 확인하기
def checkLock(big_lock):
    global lock_size
    # leftTop = len(big_lock) // lock_size
    leftTop = (key_size - 1)
    for i in range(leftTop, leftTop + lock_size):
        for j in range(leftTop, leftTop + lock_size):
            if big_lock[i][j] != 1:
                return False
    return True

def solution(key, lock):
    key_size = len(key)
    lock_size = len(lock)
    big_lock = make_big_lock(lock)
    for i in range(4):
        key = rotate(key)
        for j in range(len(big_lock) - key_size + 1):
            for k in range(len(big_lock) - key_size + 1):
                for l in range(key_size):
                    for o in range(key_size):
                        big_lock[j + l][k + o] += key[l][o]
                if checkLock(big_lock):
                    return True
                for l in range(key_size):
                    for o in range(key_size):
                        big_lock[j + l][k + o] -= key[l][o]
    return False

print(solution(key, lock))