n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]
white = 0
blue = 0

def cut(x1, x2, y1, y2):
  global white
  global blue
  w_count = 0
  b_count = 0
  for i in range(x1, x2):
    for j in range(y1, y2):
      if paper[i][j] == 1:
        b_count += 1
      else:
        w_count += 1
  if w_count == 0:
    blue += 1
    return
  elif b_count == 0:
    white += 1
    return
  else:
    cut(x1, (x1 + x2) // 2, y1, (y1 + y2) // 2)
    cut((x1 + x2) // 2, x2, y1, (y1 + y2) // 2)
    cut(x1, (x1 + x2) // 2, (y1 + y2) // 2, y2)
    cut((x1 + x2) // 2, x2, (y1 + y2) // 2, y2)

cut(0, n, 0, n)
print(white)
print(blue)
