n = int(input())
bongji = [3, 5]
d = [5001] * (n + 1)

for b in bongji:
  if b <= n:
    d[b] = 1
    for i in range(b, n + 1):
      d[i] = min(d[i - b] + 1, d[i])

if d[n] == 5001:
  print(-1)
else:
  print(d[n])
