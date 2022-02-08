from collections import deque
import sys
input = sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0<= nx < n and 0<= ny < m and graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
        

t = int(input())
ans = []
for case in range(t):
    n, m, k = map(int, input().split())
    graph = [[0] * m  for _ in range(n)]
    for i in range(k):
        x, y = map(int, input().split())
        graph[x][y] = 1
    cnt = 0    
    for a in range(n):
        for b in range(m):
            if graph[a][b] == 1:
                graph[a][b] = 0
                bfs(a, b)
                cnt += 1
    ans.append(cnt)
    
for a in ans:
    print(a)
