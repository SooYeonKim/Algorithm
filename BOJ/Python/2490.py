def check(arr):
  num_zero = arr.count(0)
  if num_zero == 0:
    print("E")
  elif num_zero == 1:
    print("A")
  elif num_zero == 2:
    print("B")
  elif num_zero == 3:
    print("C")
  else:
    print("D")

for _ in range(3):
  arr = list(map(int, input().split()))
  check(arr)
