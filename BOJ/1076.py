color = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]

res1 = input()
res2 = input()
mul_color = input()

res = color.index(res1)*10 + color.index(res2)
mul_num = 10**color.index(mul_color)

print(res*mul_num)
