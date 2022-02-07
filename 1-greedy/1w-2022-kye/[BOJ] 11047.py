n, k = map(int, input().split())
coins = []
ans = 0

for _ in range(n):
    num = int(input())
    if num <= k:
        coins.append(num)

while k != 0:
    ans += k // coins[-1]
    k = k % coins[-1]
    coins.pop()

print(ans)
