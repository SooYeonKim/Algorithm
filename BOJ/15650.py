n, m = map(int, input().split())
num_list = [i for i in range(1, n + 1)]
result = []

def dfs(count, idx):
  if count == m:
    print(*result)
    return

  for i in range(idx, n):
      count += 1
      result.append(num_list[i])
      dfs(count, i + 1)
      count -= 1
      result.pop()

dfs(0, 0)
