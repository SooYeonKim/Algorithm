n, m = map(int, input().split())
tree_list = list(map(int, input().split()))

left = 0
right = max(tree_list)
result = []
while left <= right:
  mid = (left + right) // 2
  count = 0
  for tree in tree_list:
    if tree >= mid:
      count += tree - mid

  if count == m:
    result.append(mid)
    break
  elif count > m:
    result.append(mid)
    left = mid + 1
  else:
    right = mid - 1

print(max(result))
