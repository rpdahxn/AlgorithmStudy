import sys
input = sys.stdin.readline

t = int(input())
rank = []

for _ in range(t):
    n = int(input())
    ans = 1
    rank.clear()
    rank = [list(map(int, input().split())) for i in range(n)]
    rank.sort()

    min = rank[0][1]
    for j in range(1, len(rank)):
        if min > rank[j][1]:
            ans += 1
            min = rank[j][1]

    print(ans)
