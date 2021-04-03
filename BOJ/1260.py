from collections import deque

def dfs(v):
  visited[v] = 1
  print(v, end=' ')

  for i in range(n+1):
    if graph[v][i] == 1 and visited[i] == 0:
      dfs(i)

def bfs(v):
  visited[v] = 0
  queue = deque([v])

  while queue:
    k = queue.popleft()
    print(k, end=' ')
    for i in range(n+1):
      if graph[k][i] == 1 and visited[i] == 1:
        queue.append(i)
        visited[i] = 0

n, m, v = map(int, input().split())
graph = [[0]*(n+1) for i in range(n+1)]
visited = [0 for i in range(n+1)]

for i in range(m):
  x, y = map(int, input().split())
  graph[x][y] = 1
  graph[y][x] = 1

dfs(v)
print()
bfs(v)
