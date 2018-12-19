# selenium을 활용해 로그인 진행하기 + 게시물 작성


from selenium import webdriver

driver = webdriver.Chrome('C:\Chrome Driver\chromedriver.exe')

driver.get('http://dowellcomputer.com/member/memberLoginForm.jsp')

id = "kim6394"
pw = "1234"

driver.find_element_by_name('memberID').send_keys(id)
driver.find_element_by_name('memberPassword').send_keys(pw)

driver.find_element_by_xpath('//*[@id="blackBox"]/input[1]').click()
driver.find_element_by_xpath('//*[@id="navigationBox"]/a[4]').click()
driver.find_element_by_xpath('//*[@id="blackBox"]/input[1]').click()

title = "test"
content = "test test"
source = "hello world"

driver.find_element_by_name('talkTitle').send_keys(title)
driver.find_element_by_name('talkContent').send_keys(content)
driver.find_element_by_name('talkSourceCode').send_keys(source)

driver.find_element_by_xpath('//*[@id="blackBox"]/input').click()
