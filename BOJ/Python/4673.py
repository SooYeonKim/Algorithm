num_list = []

for n in range(1, 10000):
  result = n
  result += sum(list(map(int, str(n))))
  num_list.append(result)

for i in range(1, 10001):
  if i not in num_list:
    print(i)
