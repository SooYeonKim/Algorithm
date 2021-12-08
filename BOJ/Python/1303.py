from collections import deque

def bfs(x, y, team):
  queue = deque();
  queue.append((x, y))
  count = 1
  soldier[x][y] = 1

  while queue:
    q = queue.popleft()
    x = q[0]
    y = q[1]

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or ny < 0 or nx >= n or ny >= m:
        continue
      if soldier[nx][ny] != 1 and soldier[nx][ny] == team:
        queue.append((nx, ny))
        count += 1
        soldier[nx][ny] = 1
  return count

m, n = map(int, input().split())
soldier = [list(input()) for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
W = 0
B = 0

for i in range(n):
  for j in range(m):
    if soldier[i][j] != 1:
      if soldier[i][j] == "W":
        W += bfs(i, j, "W")**2
      else:
        B += bfs(i, j, "B")**2

print(W, B)
