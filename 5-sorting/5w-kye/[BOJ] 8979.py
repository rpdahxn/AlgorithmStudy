import sys
input = sys.stdin.readline

n, k = map(int, input().split())

scores = [[] for _ in range(n)]

for i in range(n):
    nation, gold, silver, bronze = map(int, input().split())
    scores[nation-1] = [gold, silver, bronze] 
    
k_score = scores[k-1]
scores.sort(key = lambda x: (-x[0],-x[1],-x[2]))

for i in range(n):
    if k_score[:] == scores[i][:]:
        print(i+1)
        break    