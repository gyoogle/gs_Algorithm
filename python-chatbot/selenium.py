# selenium을 활용해 로그인 진행하기

from selenium import webdriver

driver = webdriver.Chrome('C:\Chrome Driver\chromedriver.exe')

driver.get('http://dowellcomputer.com/member/memberLoginForm.jsp')

id = "kim6394"
pw = "1234"

driver.find_element_by_name('memberID').send_keys(id)
driver.find_element_by_name('memberPassword').send_keys(pw)

driver.find_element_by_xpath('//*[@id="blackBox"]/input[1]').click()
