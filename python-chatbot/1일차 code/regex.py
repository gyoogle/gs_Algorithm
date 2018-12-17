import re

'''
sentence = "오늘 날짜는 2018-12-01이야"
regex = r'\d{4}-[0-9]{2}-[0-9]{2}'
rf = re.findall(regex, sentence)
print(rf)
'''
'''
sentence = "아버지가, Home에 가셨습니다!"
regex = r'[가-힣a-zA-Z0-9]'
rf = re.findall(regex, sentence)
print(rf)
'''
sentence = "The      dog        has a long tail,      and it is RED!"
regex = sentence.replace(r'[/  +/g]', '  ')
print(regex)