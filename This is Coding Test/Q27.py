from bisect import bisect_left, bisect_right

n, x = map(int, input().split())
array = list(map(int, input().split()))

right_index = bisect_right(array, x)
left_index = bisect_left(array, x)
result = right_index - left_index

if result == 0:
  print(-1)
else:
  print(result)
