import sys
input = sys.stdin.readline

n, l = map(int, input().split())

pos = list(map(int, input().split()))
pos.sort()

idx = 1
start = pos[0]
ans = 1

while idx < len(pos):
    if start + l - 1 < pos[idx]:
        start = pos[idx]
        ans += 1
    idx += 1
    
print(ans)