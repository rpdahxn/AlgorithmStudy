import sys
input = sys.stdin.readline

n = int(input())
list_A = []
list_B = []

list_A = list(map(int, input().split()))
list_B = list(map(int, input().split()))

# B의 큰 수와 A의 작은 수가 곱해지도록

list_A.sort()
ans = 0
for n in (list_A):
    B_max = max(list_B)
    ans += n * B_max
    list_B.pop(list_B.index(B_max))


print(ans)
