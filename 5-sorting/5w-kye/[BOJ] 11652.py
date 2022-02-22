import sys
input = sys.stdin.readline

n = int(input())
nums = {}
for _ in range(n):
    num = int(input())
    if num in nums.keys():
        nums[num] += 1
    else:
        nums[num] = 1

nums = sorted(nums.items(), key = lambda x: (-x[1], x[0]))
print(nums[0][0])