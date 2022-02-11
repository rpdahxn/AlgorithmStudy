from itertools import combinations
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

city = [list(map(int, input().split())) for _ in range(n)]
houses = []
chickens = []
ans = 9999

for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            houses.append([i, j])
        elif city[i][j] == 2:
            chickens.append([i, j])

        
for chi in combinations(chickens, m):  # 치킨 가게 조합
    sum_ = 0
    for h in houses:  # 집 하나당
        tmp = 999
        for i in range(m):
            tmp = min(abs(h[0] - chi[i][0]) + abs(h[1] - chi[i][1]), tmp)
        sum_ += tmp
        
    ans = min(sum_, ans)
        
print(ans)
        