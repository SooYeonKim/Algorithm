n = int(input())
input_list = [int(input()) for _ in range(n)]
num_list = []
stack = []
count = 1
check = True
for num in input_list:
  if len(num_list) == 0 or num_list[-1] <= num:
    for i in range(count, num + 1):
      num_list.append(i)
      stack.append("+")
      count += 1
    num_list.pop()
    stack.append("-")
  else:
    check = False
    break

if check == True:
  for s in stack:
    print(s)
else:
  print("NO")
