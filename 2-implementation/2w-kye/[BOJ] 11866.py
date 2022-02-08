# import sys
# input = sys.stdin.readline

# n, k = map(int, input().split())

# people = list(range(1, n+1))
# ans = []
# idx = 0

# while people:
#     idx = (idx + k - 1) % len(people)
#     ans.append(str(people.pop(idx)))

# print("<" + ", ".join(ans) + ">")

import sys
input = sys.stdin.readline

n, k = map(int, input().split())

idx = 0
people = [i+1 for i in range(n)]
ans = []

while people:
    idx  = (idx + k - 1) % len(people)
    ans.append(str(people.pop(idx)))
    
print("<" + ", ".join(ans)+ ">")