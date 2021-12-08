m, n = map(int, input().split())
prime_list = []
for num in range(2, n + 1):
  check = True
  for prime in prime_list:
    if prime * prime > num:
      break
    if num % prime == 0:
      check = False
      break
  if check == True:
    prime_list.append(num)

for prime in prime_list:
  if prime >= m and prime <= n:
    print(prime)
