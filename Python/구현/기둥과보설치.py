def solution(n, build_frame):

    visit = [[0]*n]*n

    for b in build_frame:
        # 설치
        if b[3] == 1:
            # 기둥인 경우
            if b[2] == 0:
                if visit[b[0]][b[1]] == 1 or b[1] == 0: # x, y or y == 0
                    visit[b[0]][b[1] + 1] = 1
            # 보인 경우
            if b[2] == 1:
                if visit[b[0]][b[1]] == 1: # x, y
                    visit[b[0] + 1][b[1]] = 1
                if visit[b[0] + 1][b[1]] == 1: # x+1, y
                    visit[b[0]][b[1]] = 1
        # 삭제
        # 여기서 막힘 ...
#----------------------------------------------------------------------------------------------------------------------#

def possible(installed):
    for x, y, stuff in installed:
        if stuff == 0:
            # 바닥에 세우든가, 보의 오른쪽 끝에 세우든가, 보의 왼쪽 끝에 세우든가, 기둥에 세우든가
            if y == 0 or [x - 1, y, 1] in installed or [x, y, 1] in installed or [x, y - 1, 0] in installed:
                continue
            return False
        elif stuff == 1:
            # 왼쪽 기둥 위에 놓든가, 오른쪽 기둥 위에 놓든가, 보의 양끝에 놓든가
            if [x, y - 1, 0] in installed or [x + 1, y - 1, 0] in installed or ([x - 1, y, 1] in installed and [x + 1, y, 1] in installed):
                continue
            return False
    return True

def solution(n, build_frame):
    installed = []
    for frame in build_frame:
        x, y, stuff, op = frame
        if op == 0:
            installed.remove([x, y, stuff])
            if not possible(installed):
                installed.append([x, y, stuff])
        if op == 1:
            installed.append([x, y, stuff])
            if not possible(installed):
                installed.remove([x, y, stuff])
    return sorted(installed)

print(solution(5, [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]))
print(solution(5, 	[[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]))