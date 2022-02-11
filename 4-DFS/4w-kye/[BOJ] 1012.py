import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(i, j):
    graph[i][j] = 0

    for idx in range(4):
        x, y = i + dx[idx], j + dy[idx]
        if 0<= x < n and 0<= y < m and graph[x][y] == 1:
            dfs(x, y)
    return
        

t = int(input())

for case in range(t):
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]
    
    for _ in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1
        
    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                dfs(i, j)
                cnt += 1
    
    print(cnt)