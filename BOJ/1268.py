import sys
input = sys.stdin.readline

n = int(input())
cnt = [[0]*n for _ in range(n)]
data = [list(map(int, input().split())) for _ in range(n)]

for i in range(5):
  for j in range(n-1):
    for k in range(j+1, n):
      if data[j][i] == data[k][i]:
        cnt[j][k] = 1
        cnt[k][j] = 1

sum_data = [sum(cnt[i]) for i in range(n)]
print(sum_data.index(max(sum_data))+1)
