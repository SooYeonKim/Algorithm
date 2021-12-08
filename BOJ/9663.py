n = int(input())
a = [False] * n
b = [False] * (2 * n - 1)
c = [False] * (2 * n - 1)
result = 0

def dfs(count):
  global result

  if count == n:
    result += 1
    return

  for i in range(n):
    if a[i] == False and b[count - i + n - 1] == False and c[count + i] == False:
      a[i] = True
      b[count - i + n - 1] = True
      c[count + i] = True
      dfs(count + 1)
      a[i] = False
      b[count - i + n - 1] = False
      c[count + i] = False

dfs(0)
print(result)
