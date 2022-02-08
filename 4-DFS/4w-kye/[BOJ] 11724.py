import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n, m = map(int, input().split())
nodes = [[] for _ in range(n+1)]
# visited =  [False] * (n+1)
visited =  [False for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    nodes[u].append(v)
    nodes[v].append(u)
    
def dfs(i):
    visited[i] = True
    for num in nodes[i]:
        if not visited[num]:
            dfs(num)
cnt = 0
for i in range(1, n+1):
    if not visited[i]:
        dfs(i)
        cnt += 1
print(cnt)