a, b = map(int, input().split())
m = min(a, b)
GCF = 1
LCM = 1

for i in range(m, 0, -1):
  if a % i == 0 and b % i == 0:
    GCF = i
    LCM = i
    break

LCM *= a // GCF
LCM *= b // GCF

print(GCF)
print(LCM)
