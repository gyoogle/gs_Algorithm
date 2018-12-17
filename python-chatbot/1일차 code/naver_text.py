from elice_utils import EliceUtils
import urllib.request
from bs4 import BeautifulSoup

elice_utils = EliceUtils()


def main():
    
    # URL 데이터를 가져올 사이트 url 입력
    url = "http://www.naver.com"
    soup = urllib.request.urlopen(url).read()
    #print(soup)
    # URL 주소에 있는 HTML 코드를 soup에 저장합니다.
    temp = BeautifulSoup(soup, "html.parser")
    spans = temp.find_all("span", class_="ah_k")
    
    #print(spans)
    
    
    list = []

    for naver_text in spans:
        list.append(naver_text.get_text())

    print(list)


if __name__ == "__main__":
    main()
