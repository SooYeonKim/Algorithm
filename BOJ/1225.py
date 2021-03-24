import sys
input = sys.stdin.readline

num1, num2 = map(list, input().split())
a = list(map(int, num1))
b = list(map(int, num2))

# 123 45 -> 1*4 + 1*5 + 2*4 + 2*5 + 3*4 + 3*5 = 54 (시간 초과 발생)
# 123 45 -> (1+2+3) * (4+5) = 54
print(sum(a)*sum(b))
