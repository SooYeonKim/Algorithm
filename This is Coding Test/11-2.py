s = list(map(int, input()))

temp = s[0]
for i in range(1, len(s)):
  if temp <= 1 or s[i] <= 1:
    temp = temp + s[i]
  else:
    temp = temp * s[i]

print(temp)
