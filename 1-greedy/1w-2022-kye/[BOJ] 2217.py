import sys
input = sys.stdin.readline

n = int(input())

ropes = []
for _ in range(n):
    ropes.append(int(input()))

ropes.sort(reverse=True)
ans = 0
for i in range(1, n+1):
    tmp = (i * ropes[i-1])
    ans = max(tmp, ans)

print(ans)
