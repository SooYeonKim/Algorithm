import sys
input = sys.stdin.readline

n = int(input())
num_list = []
dic = {}
for _ in range(n):
  num = int(input())
  num_list.append(num)
  if num in dic:
    dic[num] += 1
  else:
    dic[num] = 1

num_list.sort()
dic = sorted(dic.items(), key = lambda x : (-x[1], x[0]))
frequency = 0
if len(dic) > 1 and dic[0][1] == dic[1][1]:
  frequency = dic[1][0]
else:
  frequency = dic[0][0]
max_num = num_list[-1]
min_num = num_list[0]

print(round(sum(num_list) / n))
print(num_list[n // 2])
print(frequency)
print(max_num - min_num)
