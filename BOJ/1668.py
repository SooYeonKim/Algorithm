num = int(input())
list = []
for i in range(num):
  list.append(int(input()))

temp1 = list[0]
count1 = 1
for j in range(1, num):
  if temp1 < list[j]:
    temp1 = list[j]
    count1 += 1

print(count1)

temp2 = list[num-1]
count2 = 1
for k in range(num-2, -1, -1):
  if temp2 < list[k]:
    temp2 = list[k]
    count2 += 1

print(count2)
