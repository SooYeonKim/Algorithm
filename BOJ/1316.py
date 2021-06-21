n = int(input())

result = 0
for _ in range(n):
  word = input()
  temp = [word[0]]
  check = True

  for i in range(1, len(word)):
    if word[i] == word[i - 1]:
      continue
    else:
      if word[i] in temp:
        check = False
        break
      else:
        temp.append(word[i])

  if check == True:
    result += 1

print(result)
