import sys
input = sys.stdin.readline

n, c = map(int, input().split())

houses = [int(input()) for _ in range (n)]
houses.sort()
# 최소 거리, 최대거리
left, right = 1, houses[-1] - houses[0]

def binary(houses, left, right):
    while left <= right:
        mid = (left + right) // 2  # 공유기 사이 거리에 해당
        start = houses[0]
        count = 1  # 첫 번째 집에 공유기 설치 완료
        
        for i in range(1, len(houses)):
            if houses[i] >= start + mid:
                start = houses[i]
                count += 1
        
        if count >= c:
            left = mid + 1
            ans = mid
        else:
            right = mid - 1
            
    return ans
            
print(binary(houses, left, right))