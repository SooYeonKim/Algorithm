T = int(input())
for _ in range(T):
  a, b = map(int, input().split())
  temp_a = max(a, b)
  temp_b = min(a, b)
  temp = 0
  while temp_b != 0:
    temp = temp_a % temp_b
    temp_a = temp_b
    temp_b = temp
  GCD = temp_a
  LCM = GCD * (a // GCD) * (b // GCD)
  print(LCM)
