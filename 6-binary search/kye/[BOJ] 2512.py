import sys
input = sys.stdin.readline

n = int(input())
budgets = list(map(int, input().split()))
m = int(input())

start = 1
end = max(budgets)

def binary(budgets, start, end):
    ans= 0
    while start <= end:
        mid = (start + end) // 2

        res = []
        for budget in budgets:
            if budget >= mid:
                res.append(mid)
            else:
                res.append(budget)
        
        if sum(res) <= m:
            start = mid + 1
            ans = mid
        else:
            end = mid - 1
    return ans

if sum(budgets) <= m:
    print(max(budgets))
else:
    print(binary(budgets, start, end))
    

