from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = []
visited = [[0]*m for _ in range(n)]

for _ in range(n):
    graph.append(list(input().rstrip()))
    
    
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

visited[0][0] = 1

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == '1' and visited[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx, ny))
                    
    return visited[n-1][m-1]

print(bfs(0, 0))