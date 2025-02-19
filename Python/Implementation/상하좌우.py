n = int(input())
move = input().split()

def solution(n, move) :
    # L R U D
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    move_types = ['L', 'R', 'U', 'D']

    y, x = 1, 1

    for m in move:
        for d in range(4):
            if m == move_types[d]:
                nx = x + dx[d]
                ny = y + dy[d]
        if nx < 1 or ny < 1 or nx > n or ny > n:
            continue
        x, y = nx, ny

    print(y, x)

solution(n, move)