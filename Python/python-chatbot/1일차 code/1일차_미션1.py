from elice_utils import EliceUtils
import urllib.request
from bs4 import BeautifulSoup

elice_utils = EliceUtils()


def main():
    # URL 데이터를 가져올 사이트 url 입력
    url = "https://himchanyoon1992.tistory.com/1"

    # URL 에 있는 HTML 코드를 soup에 저장합니다.
    soup = BeautifulSoup(urllib.request.urlopen(url).read(), "html.parser")

    comments = []

    # 댓글 부분을 찾아서 list에 하나씩 댓글을 삽입합니다.
    for comment in soup.find_all("span", class_="txt_reply"):
        comments.append(comment)

    # list를 출력합니다.
    print(comments)




if __name__ == "__main__":
    main()
