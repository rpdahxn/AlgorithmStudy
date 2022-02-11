# dfs
def dfs(graph, node, visited):
    visited[node] = True
    print(node, end=" ")
    for i in graph[node]:
        if not visited[i]:
            dfs(graph, i, visited)
# bfs
def bfs(graph, node, visited):
    queue = deque([node])
    visited[node] = True
    while queue:
        v = queue.popleft()
        print(v, end = " ")
        for i in (graph[v]):
            if not visited[i]:
                queue.append(i)
                visited[i] = True            
            
from collections import deque
import sys
input = sys.stdin.readline

n, m, v = map(int, input().split())

# 정점 개수만큼 만들기
graph = [[] for _ in range(n+1)]

for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)
        
for _ in range(n+1):
    graph[_].sort()


visited1 = [False for _ in range(n+1)]
dfs(graph, v, visited1)
print()
visited2 = [False for _ in range(n+1)]
bfs(graph, v, visited2)