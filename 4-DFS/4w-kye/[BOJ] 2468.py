import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(j, k):
    visited[j][k] = True
    
    for idx in range(4):
        x = j + dx[idx]
        y = k + dy[idx]
        if 0<= x < n and 0<= y < n:
            if heights[x][y] > h and not visited[x][y]:
                dfs(x, y)
    

n = int(input())
heights = [list(map(int, input().split())) for _ in range(n)]

ans = 0
for h in range(max(map(max, heights))):
    visited = [[False] * n for _ in range(n)]

    cnt = 0
    for j in range(n):
        for k in range(n):
            if not visited[j][k] and heights[j][k] > h:
                dfs(j, k)
                cnt += 1
    ans = max(ans, cnt)
    
print(ans)       