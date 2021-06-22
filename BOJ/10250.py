T = int(input())
for _ in range(T):
  h, w, n = map(int, input().split())
  a = n % h
  b = n // h + 1

  if a == 0:
    a = h
    b -= 1

  print(str(a) + str(b).zfill(2))
