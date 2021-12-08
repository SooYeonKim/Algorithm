s = input()
num_zero = 0
num_one = 0

if s[0] == '1':
  num_zero += 1
else:
  num_one += 1

for i in range(len(s)-1):
  if s[i] != s[i+1]:
    if s[i+1] == '1':
      num_zero += 1
    else:
      num_one += 1

print(min(num_zero, num_one))
