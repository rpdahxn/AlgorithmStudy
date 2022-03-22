import sys
input = sys.stdin.readline

k, n = map(int, input().split())
array = [int(input()) for _ in range(k)]
array.sort()

start, end = 1, array[-1]

while (start <= end):
    mid = (start + end) // 2
    tmp = 0
    
    for length in array:
        tmp += length // mid
        
    if tmp >= n:
        ans = mid
        start = mid + 1
    else:
        end = mid - 1
        
print(ans) 

