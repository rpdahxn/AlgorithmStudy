import sys
input = sys.stdin.readline

ans = 0

for i in range(int(input())):
    vocab = input().rstrip()
    if list(vocab) == sorted(vocab, key=vocab.find):
        ans += 1

print(ans)
