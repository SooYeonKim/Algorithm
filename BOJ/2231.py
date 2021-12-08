n = int(input())
result = 0

for i in range(1, n):
  sum_num = i
  sum_num += sum(list(map(int, (str(i)))))
  if sum_num == n:
    result = i
    break

print(result)
