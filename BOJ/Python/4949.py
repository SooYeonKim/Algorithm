while True:
  string = input()
  if string == ".":
    break

  stack = []
  for s in string:
    if s == ")":
      if len(stack) > 0 and stack[-1] == "(":
        stack.pop()
      else:
        stack.append(s)
    elif s == "]":
      if len(stack) > 0 and stack[-1] == "[":
        stack.pop()
      else:
        stack.append(s)
    elif s == "(" or s == "[":
      stack.append(s)
    else:
      continue

  if len(stack) == 0:
    print("yes")
  else:
    print("no")
