current_time = list(map(int, input().split(":")))
start_time = list(map(int, input().split(":")))

current_sec = current_time[0]*3600 + current_time[1]*60 + current_time[2]
start_sec = start_time[0]*3600 + start_time[1]*60 + start_time[2]

if current_sec > start_sec:
  start_sec += 24 * 60 * 60

value = start_sec - current_sec
result = []
hour = value // 3600
result.append(str("%02d" %hour))
value -= hour * 3600
min = value // 60
result.append(str("%02d" %min))
value -= min * 60
sec = value
result.append(str("%02d" %sec))

print(":".join(result))
