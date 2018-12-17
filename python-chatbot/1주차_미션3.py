from elice_utils import EliceUtils
import urllib.request
from bs4 import BeautifulSoup
import re

elice_utils = EliceUtils()


def main():

    url = "https://himchanyoon1992.tistory.com/5"
    soup = BeautifulSoup(urllib.request.urlopen(url).read(), "html.parser")

    # 크롤링해서 글 내용을 text에 담기
    text = soup.find("div", class_="tt_article_useless_p_margin").get_text()
    
    # 숫자만 찾는 정규식 코드
    compile_text = re.compile('\d+')
    match_text = compile_text.findall(text)

    # 숫자만 출력
    print(match_text)



if __name__ == "__main__":
    main()
