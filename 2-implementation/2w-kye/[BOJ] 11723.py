import sys
input = sys.stdin.readline

S = set()

for _ in range(int(input())):
    command = list(input().split())
    
    if command[0] == "all":
        # for문보다 실행시간이 짧다.
        S = set(['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20'])
    elif command[0] == "empty":
        S = set()
    elif command[0] == "add":
        S.add(command[1])
    elif command[0] == "remove":
        S.discard(command[1])
    elif command[0] == "check":
        print(int(command[1] in S))
    elif command[0] == "toggle":
        if command[1] in S:
            S.remove(command[1])
        else:
            S.add(command[1])