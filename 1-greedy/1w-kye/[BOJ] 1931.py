import sys

input = sys.stdin.readline

n = int(input())
times = []

for _ in range(n):
    time = list(map(int, input().split()))
    times.append(time)

times.sort()
times.sort(key=lambda a: a[1])

end = times[0][1]
ans = 1
for i in range(1, n):
    if times[i][0] >= end:
        ans += 1
        end = times[i][1]

print(ans)
