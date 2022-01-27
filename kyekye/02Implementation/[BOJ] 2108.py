from collections import Counter
import sys
input = sys.stdin.readline

n = int(input())
nums = [int(input()) for _ in range(n)]

print(round(sum(nums)/len(nums)))
nums.sort()
print(nums[len(nums)//2])

counts = Counter(nums).most_common()
if len(counts)>1 and (counts[0][1] == counts[1][1]):
    print(counts[1][0])
else:
    print(counts[0][0])

print(max(nums)-min(nums))