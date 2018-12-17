from elice_utils import EliceUtils
import urllib.request
from bs4 import BeautifulSoup

elice_utils = EliceUtils()


def main():
    print("href 출력해보기")

    list_href = []

    url = "http://sports.donga.com/Enter"
    soup = BeautifulSoup(urllib.request.urlopen(url).read(), "html.parser")

    # 반복문을 사용해 원하는 정보 range(3,23)까지 find("a")["href"] 를 사용해서
    # href 모두 수집하여 list_href에 저장

    for atags in soup.find_all("a"):
        list_href.append(atags["href"])
    
    print(list_href)


if __name__ == "__main__":
    main()
