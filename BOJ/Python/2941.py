string = input()

result = 0
for i, s in enumerate(string):
  if s == "=" or s == "-":
    continue
  elif (s == "l" or s == "n") and (i + 1) < len(string) and string[i + 1] == "j":
    continue
  elif s == "d" and (i + 2) < len(string) and string[i + 1] == "z" and string[i + 2] == "=":
    continue
  else:
    result += 1

print(result)
