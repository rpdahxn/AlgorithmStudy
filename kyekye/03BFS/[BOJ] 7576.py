from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(m)]
for i in range(m):
    graph[i] = (list(map(int,input().split())))

queue = deque()
for i in range(m):
    for j in range(n):
        if graph[i][j] == 1:
            queue.append((i, j))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
    
def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0<= nx < m and 0<= ny < n and graph[nx][ny] == 0:
                # 익은 사과
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

bfs()

ans = 0
for i in graph:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    ans = max(ans, max(i))
    
print(ans - 1)