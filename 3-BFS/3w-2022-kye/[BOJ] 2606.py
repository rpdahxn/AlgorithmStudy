from collections import deque
import sys
input = sys.stdin.readline

c = int(input())
n = int(input())
ans = 0

graph = [[] for _ in range(c+1)]
visited = [False] * (c+1)
for _ in range(n):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)


queue = deque()
queue.append(1)
while queue:
    x = queue.popleft()
    visited[x] = True
    for node in graph[x]:
        if not visited[node]:
            queue.append(node)
            visited[node] = True
            ans += 1
            
print(ans)