import sys
input = sys.stdin.readline

nums = list(input().rstrip())
nums.sort(reverse=True)

if nums[-1] != '0' or sum(map(int, nums)) % 3 != 0:
    print(-1)
else:
    print("".join(nums))
