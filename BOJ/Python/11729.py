n = int(input())
count = 0
ord_list = []

def move(n, fr, to, other):
  global count

  if n < 1:
    return

  move(n - 1, fr, other, to)
  count += 1
  ord_list.append((fr, to))
  move(n - 1, other, to, fr)

move(n, 1, 3, 2)
print(count)
for fr, to in ord_list:
  print(fr, to)
