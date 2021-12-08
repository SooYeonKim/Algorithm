from collections import deque
n, m = map(int, input().split())
pop_list = list(map(int, input().split()))
num_list = deque([i for i in range(1, n + 1)])
count = 0
for pop_num in pop_list:
  pop_index = num_list.index(pop_num)
  if pop_index <= len(num_list) - pop_index:
    for i in range(pop_index):
      num_list.append(num_list.popleft())
      count += 1
    num_list.popleft()
  else:
    for i in range(len(num_list) - pop_index):
      num_list.appendleft(num_list.pop())
      count += 1
    num_list.popleft()
print(count)
