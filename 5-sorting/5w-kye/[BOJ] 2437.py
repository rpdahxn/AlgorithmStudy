import sys
input = sys.stdin.readline

n = int(input())
weights = list(map(int, input().split()))
weights.sort()

tmp = 1
for i in range(len(weights)):
    if tmp < weights[i]:
        break
    tmp += weights[i]
    
print(tmp)