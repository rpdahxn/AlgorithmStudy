import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))

start, end = 1, max(trees)
def binary(trees, start, end):
    ans = 0
    while start <= end:
        mid = (start + end) // 2
        tmp = sum(x - mid for x in trees if x > mid)
                
        if tmp >= m:
            start = mid + 1
            ans = mid  # 적어도 M미터 나무를 자르기 위한 높이의 최댓값일 수 있으니까
        else:
            end = mid - 1
    print(ans)
    
binary(trees, start, end)