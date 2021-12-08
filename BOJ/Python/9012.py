T = int(input())
for _ in range(T):
  string = input()
  stack = []
  check = True
  for s in string:
    if s == "(":
      stack.append("(")
    elif len(stack) != 0:
      stack.pop()
    else:
      check = False
      break
  if check == True and len(stack) == 0:
    print("YES")
  else:
    print("NO")
