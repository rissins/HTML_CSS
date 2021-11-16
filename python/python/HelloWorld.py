print("helloWorld1111")

a = "Hi"
print(a.upper())

year = 2021
month = 11
day = 15
print(year, month, day, sep="/")

a = 10
b = 20
c = a + b
print(c)

price = 3000
num = 3
pay = 10000
change = pay - price * num
print("거스름돈 %d원" % change)

"""
print()함수를 이용한 데이터 출력
- 작성자 : 홍길동
- 일자 : 2021.11.02
"""

# name = input("당신의 이름은 ?")  # 변수 name : 이름
# age = int(input("당신의 나이는 ?"))
# print("이름은 %s, 나이는 %d" % (name, age))

print("================================")

number1 = 10
number2 = 20
print("%s + %d = %d" % (number1, number2, number1 + number2))

print("================================")

print("10" + " + 20 = " + "30")

print("================================")

# fruit1 = input("첫 번째 과일으 입력하세요 : ")
# fruit2 = input("두 번째 과일으 입력하세요 : ")
# print("%s 와 %s 는 내가 좋아하는 과일이다." % (fruit1, fruit2))
# print("================================")
#
# a = "와"
# b = "는"
# c = "내가"
# d = "좋아하는"
# e = "과일이다."
#
# print(fruit1, a, fruit2, b, c, d, e, sep="")
#
# print("%s와 %s는 내가 좋아하는 과일이다." % (fruit1, fruit2))

num1 = int(input("첫 번째 숫자를 입력하세요: "))
num2 = int(input("두 번째 숫자를 입력하세요: "))
num3 = float(round(num1 / num2, 3))
print("%d / %d = %s" % (num1, num2, num3))
