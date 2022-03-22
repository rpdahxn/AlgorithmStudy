import sys
input = sys.stdin.readline

n, m = map(int, input().split())

numerator = 1
denominator = 1

while m != 0:
    numerator *= n
    n -= 1
    denominator *= m
    m -= 1
    
print(numerator//denominator)
