import sys
input = sys.stdin.readline

case = int(input())

# 인덱스 정보를 유지할 것

for _ in range(case):
    n, m = map(int, input().split())  # 문서의 개수랑 찾는 문서의 위치
    
    file_list = list(map(int, input().split()))  # 문서들 중요도 입력받기
    check_list = [0 for _ in range(n)]
    check_list[m] = 1  # 내가 알고 싶은 문서 표시
    
    ans = 0
    while True:
        if file_list[0] == max(file_list):
            ans += 1
            
            if check_list[0] != 1:
                file_list.pop(0)
                check_list.pop(0)
            else:
                print(ans)
                break
        else:
            file_list.append(file_list.pop(0))
            check_list.append(check_list.pop(0))

    
