n, m = map(int, input().split())
cards = list(map(int, input().split()))
result = []

for i in range(n - 2):
  for j in range(i + 1, n - 1):
    for k in range(j + 1, n):
      temp = cards[i] + cards[j] + cards[k]
      if temp <= m:
        result.append(temp)

print(max(result))
