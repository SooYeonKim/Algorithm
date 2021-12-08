data = []
for _ in range(int(input())):
  data.append(list(map(int, input().split())))

data.sort(key=lambda x:(x[0], x[1]))

for d in data:
  print(str(d[0]) + " " + str(d[1]))
