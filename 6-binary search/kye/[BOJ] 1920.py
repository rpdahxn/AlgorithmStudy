import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
nums.sort()

m = int(input())
check_nums = list(map(int, input().split()))

def binary_search(nums, check_num):
    start = 0
    end = n - 1
    
    while start <= end:
        mid = (start + end) // 2
        if nums[mid] == check_num:
            return 1
        elif nums[mid] > check_num:
            end = mid - 1
        else:
            start = mid + 1
    return 0
    
for check_num in check_nums:
    print(binary_search(nums, check_num))