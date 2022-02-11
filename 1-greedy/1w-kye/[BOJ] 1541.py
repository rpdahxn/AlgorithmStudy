# import sys
# input = sys.stdin.readline

# string = input()

# tmp = ""
# f = 1
# ans = 0

# for c in (string):
#     # 숫자
#     if c != "+" and c != "-":
#         tmp += c
#     else:
#         ans += f * int(tmp)
#         if c == "-" and f != -1:
#             f *= -1
#         tmp = ""

# print(ans + (f * int(tmp)))

import sys
input = sys.stdin.readline

string = input().split("-")

ans = 0
for i in string[0].split("+"):
    ans += int(i)
for i in string[1:]:
    for j in i.split("+"):
        ans -= int(j)

print(ans)
