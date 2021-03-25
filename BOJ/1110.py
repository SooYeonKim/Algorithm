num = int(input())

new_num = num
count = 0
while True:
  quotient = new_num // 10
  remainder = new_num % 10
  temp = quotient + remainder
  new_num = remainder*10 + (temp % 10)
  count += 1
  if new_num == num:
    break

print(count)
