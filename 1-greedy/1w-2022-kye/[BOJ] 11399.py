n = int(input())
time = list(map(int, input().split()))

time.sort()

tmp = 0
ans = []

for i in (time):
    tmp += i
    ans.append(tmp)

print(sum(ans))
