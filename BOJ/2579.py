n = int(input())
jumsu = []
dp = [0] * n
for _ in range(n):
  jumsu.append(int(input()))

dp[0] = jumsu[0]
if len(jumsu) > 1:
  dp[1] = dp[0] + jumsu[1]
if len(jumsu) > 2:
  dp[2] = max(dp[0] + jumsu[2], jumsu[1] + jumsu[2])

for i in range(3, n):
  dp[i] = max(dp[i-2], dp[i-3] + jumsu[i - 1]) + jumsu[i]

print(dp[n - 1])
