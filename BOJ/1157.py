string = input()
string = string.upper()

frequency = {}
for s in string:
  if s in frequency:
    frequency[s] += 1
  else:
    frequency[s] = 1

frequency = sorted(frequency.items(), key = lambda x : -x[1])
if len(frequency) >= 2 and frequency[0][1] == frequency[1][1]:
  print("?")
else:
  print(frequency[0][0])
