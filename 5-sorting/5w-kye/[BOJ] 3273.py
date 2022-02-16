import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
x = int(input())

ans = 0

nums.sort()
left = 0
right = len(nums) - 1

while left < right:
    if nums[left] + nums[right] == x:
        ans += 1
        left += 1
        right -= 1
    elif nums[left] + nums[right] > x:
        right -= 1
    else:
        left += 1
print(ans)