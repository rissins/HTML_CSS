# email1 = input("앞 부분")
# email2 = input("뒷 부분")
# email = email1 + "@" + email2
#
# print(" - 이메일 주소 : ", email)

# name = input("이름")
# addr = input("주소")
# number = input("전화번호")
# print(" - 이름 : ", name)
# print(" - 주소 : ", addr)
# print(" - 전화번호 : ", number)


# upper = int(input("윗변"))
# under = int(input("밑변"))
# height = int(input("높이"))
# area = ((upper+under) * height) / 2
# print(" - 사다리꼴 면적 : ", area)


str = '가는 말이 고와야 오는 말이 곱다.'
print("추출문자 : ", str[10:14])

#
# number = input("열 자리 숫자 입력")
# print(number[8:])

# year = input("년")
# month = input("월")
# day = input("일")
# list = [year,month,day]
# print('.'.join(list))


# width = int(input("사각형의 너비"))
# height = int(input("사각형의 높이"))
# print("사각형의 너비 : %d cm" %width)
# print("사각형의 높이 : %d cm" %height)
# print("둘레이길 : %d cm" %(height*2+width*2))
# print("면적 : %d cm^2" %(height*width))

# radius = float(input("반지름"))
# one = round(float(2 * radius * 3.14),2)
# area = round(float(radius * radius * 3.14),2)
# print("%s cm" %radius)
# print("원의 둘레 %s" %one)
# print("원의 면적 %s" %area)

# kg = int(input("변환할 킬로그램은 ? "))
# pound = round(kg * 2.204623,2)
# ounce = round(kg * 35.273962,2)
# print("킬로그램     파운드     온스")
# print("-----------------------------------")
# print(kg, pound, ounce)


# number = int(input("숫자를 입력하세요 : "))
# if number > 10:
#     print("%d은(는) 10보다 크다" %number)
# else:
#     print("%d은(는) 10보다 작다" %number)

# month = int(input("월을 숫자로 입력하세요 : "))
# if month == 3 or month == 4 or month == 5:
#     print("%d월은 봄입니다." % month)
# elif month == 6 or month == 7 or month == 8:
#     print("%d월은 여름입니다." % month)
# elif month == 9 or month == 10 or month == 11:
#     print("%d월은 가을입니다." % month)
# elif month == 12 or month == 1 or month == 2:
#     print("%d월은 겨울입니다." % month)


# grade = input("등급을 입력해주세요 : ")
# if grade == "A+":
#     print("등급: %s, 평점 : 4.5" %grade)
# if grade == "A":
#     print("등급: %s, 평점 : 4.0" %grade)
# if grade == "B+":
#     print("등급: %s, 평점 : 3.5" %grade)
# if grade == "B":
#     print("등급: %s, 평점 : 3.0" %grade)
# if grade == "C+":
#     print("등급: %s, 평점 : 2.5" %grade)
# if grade == "C":
#     print("등급: %s, 평점 : 2.0" %grade)
# if grade == "D+":
#     print("등급: %s, 평점 : 1.5" %grade)
# if grade == "D":
#     print("등급: %s, 평점 : 1.0" %grade)
# if grade == "F":
#     print("등급: %s, 평점 : 0" %grade)

# gender = int(input("주민번호 뒷자리 첫 번째 숫자 : "))
# if gender == 1 or gender == 3:
#     print("남성")
# if gender == 2 or gender == 4:
#     print("여성")

# middle = 0
# number1 = int(input("첫 번쨰 정수는 ? : "))
# number2 = int(input("두 번쨰 정수는 ? : "))
# number3 = int(input("세 번쨰 정수는 ? : "))
# if number1 > number2 and number1 > number3:
#     if number2 > number3:
#         middle = number2
#     else:
#         middle = number3
# if number2 > number3 and number2 > number1:
#     if number3 > number1:
#         middle = number3
#     else:
#         middle = number1
# if number3 > number1 and number3 > number2:
#     if number1 > number2:
#         middle = number1
#     else:
#         middle = number2
#
# print("%d, %d, %d 중에서 중간 값은 %d 입니다." %(number1,number2, number3, middle))


# moeum = ["a","e","i","o","u"]
# jaeum = ["t"]
#
# text = input("영문 소문자 하나를 입력하세요: ")
# if text in moeum:
#     print("모음")
# elif text in jaeum:
#     print("자음")
    
    
# age = int(input("나이는 ? "))
# if age < 65:
#     price = 2000
# else:
#     price = 0
# print("나이 : %d세" %age)
# print("입장료 : %d원" %price)


# pil = int(input("필기시험 점수는 ?"))
# sil = int(input("실기시험 점수는 ?"))
# print("필기시험 점수 : %d" %pil)
# print("실기시험 점수 : %d" %sil)
# if pil >= 80 and sil >= 80:
#     print("판정 : 합격")
# else:
#     print("판정 : 불합격")

# number1 = int(input("첫 번째 숫자를 입력하세요 : "))
# number2 = int(input("두 번째 숫자를 입력하세요 : "))
# sum = number1 + number2
# print("%d + %d = %d" %(number1,number2,sum))
# if sum % 3 == 0:
#     print("%d는 3의 배수다" %sum)
# else:
#     print("%d는 3의 배수가 아니다" %sum)
# 
# number = int(input("숫자를 입력하세요 : "))
# if number % 2 == 0:
#     print("%d는 짝수이다" %number)
# else:
#     print("%d는 홀수이다" %number)

# number = input("수를 입력하세요 : ")
# if len(number) == 1:
#     print("%s는 한 자리 숫자이다." %number)
# elif len(number) == 2:
#     print("%s는 두 자리 숫자이다." %number)
# elif len(number) == 3:
#     print("%s는 세 자리 숫자이다." %number)
# else:
#     print("오류")

text = input("문자열을 입력하세요 : ")
count = len(text)
print(count)
if count % 2 == 0:
    print("짝수")
else:
    print("홀수")
