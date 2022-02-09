import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

dx = [0, 0, -1, -1, -1, 1, 1, 1]
dy = [-1, 1, -1, 0, 1, -1, 0, 1]

def dfs(j, k):
    maps[j][k] = 0
    
    for idx in range(8):
        x = j + dx[idx]
        y = k + dy[idx]
        if 0<= x < h and 0<= y < w and maps[x][y] == 1:
            dfs(x, y)
        

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    
    maps = [list(map(int, input().split())) for _ in range(h)]
    cnt = 0
    for j in range(h):
        for k in range(w):
            if maps[j][k] == 1:
                dfs(j, k)
                cnt += 1
    print(cnt)
