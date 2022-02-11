import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

n = int(input())
pic = [list(input()) for _ in range(n)]

visited1 = [[False]*n for _ in range(n)]
visited2 = [[False]*n for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def dfs1(i, j):
    visited1[i][j] = True
    
    for idx in range(4):
        x = i + dx[idx]
        y = j + dy[idx]
        if 0<= x < n and 0<= y < n and not visited1[x][y]:
            if pic[x][y] == pic[i][j]:
                dfs1(x, y)
                
RG = ['R', 'G']
B = ['B']
def dfs2(i, j):
    visited2[i][j] = True
    
    for idx in range(4):
        x = i + dx[idx]
        y = j + dy[idx]
        if 0<= x < n and 0<= y < n and not visited2[x][y]:
            if (pic[i][j] in B and pic[x][y] in B) or (pic[i][j] in RG and pic[x][y] in RG):
                dfs2(x, y)    
    
cnt1 = 0
cnt2 = 0
for i in range(n):
    for j in range(n):
        if not visited1[i][j]:
            dfs1(i, j)
            cnt1 += 1
        if not visited2[i][j]:
            dfs2(i, j)
            cnt2 += 1
                
print(cnt1, cnt2)
                    
            