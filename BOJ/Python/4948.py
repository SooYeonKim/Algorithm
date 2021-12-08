prime_list = []
for num in range(2, 123456 * 2):
  check = True
  for prime in prime_list:
    if prime * prime > num:
      break
    if num % prime == 0:
      check = False
      break
  if check == True:
    prime_list.append(num)

while True:
  n = int(input())
  if n == 0:
    break

  count = 0
  for prime in prime_list:
    if prime > n and prime <= 2 * n:
      count += 1
  print(count)
