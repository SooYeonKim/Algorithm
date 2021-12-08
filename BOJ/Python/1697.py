from collections import deque

def bfs(n):
  queue = deque([[n, 0]])

  while queue:
    q = queue.popleft()
    loc = q[0]
    time = q[1]

    if visited[loc] == 0:
      visited[loc] = 1
      if loc == k:
        return time
      time += 1
      if (loc + 1) <= 100000:
        queue.append([loc + 1, time])
      if (loc - 1) >= 0:
        queue.append([loc - 1, time])
      if (loc * 2) <= 100000:
        queue.append([loc * 2, time])
  return time

n, k = map(int, input().split())
visited = [0 for _ in range(100001)]
print(bfs(n))
