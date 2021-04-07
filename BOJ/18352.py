import sys
input = sys.stdin.readline
from collections import deque

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
visited = [False]*(n+1)
distance = [0]*(n+1)

def bfs(x):
  queue = deque()
  queue.append(x)
  visited[x] = True

  while queue:
    num = queue.popleft()
    for v in graph[num]:
      if visited[v] == False:
        queue.append(v)
        visited[v] = True
        distance[v] = distance[num] + 1

bfs(x)
result_list = list(filter(lambda x: distance[x] == k, range(len(distance))))

if len(result_list) != 0:
  for i in result_list:
    print(i)
else:
  print(-1)
