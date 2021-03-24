import sys

N, m, M, T, R = map(int, input().split())
exercise = 0
time = 0
pulse = m

if pulse > M or pulse + T > M:
  print(-1)
  sys.exit()

while exercise < N:
  if pulse+T <= M:
    time += 1
    exercise += 1
    pulse += T
  else:
    while pulse+T > M:
      time += 1
      pulse -= R
      if pulse < m:
        pulse = m

print(time)
