import sys
input = sys.stdin.readline

cases = int(input())

for _ in range(cases):
    n, idx = map(int, input().split())
    files = list(map(int, input().split()))
    check = [0 for _ in range(n)]
    check[idx] = 1
    
    count = 0
    while files:
        if max(files) == files[0]:
            files.pop(0)
            count += 1
            if check.pop(0):
                print(count)
                break
        else:
            files.append(files.pop(0))
            check.append(check.pop(0))