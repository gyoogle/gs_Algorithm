from elice_utils import EliceUtils
import urllib.request
from bs4 import BeautifulSoup

elice_utils = EliceUtils()


def main():

    comments = []

    # 댓글을 가져와야 하는 URL 3개를 반복문을 이용해서 한꺼번에 가져오기
    # url = "https://himchanyoon1992.tistory.com/2"
    # url = "https://himchanyoon1992.tistory.com/3"
    # url = "https://himchanyoon1992.tistory.com/4"

    # 반복문의 i와 url을 합쳐주는 과정은 str()을 사용하시면 됩니다.

    for i in range(2,4):
        url = "https://himchanyoon1992.tistory.com/" + str(i)
        soup = BeautifulSoup(urllib.request.urlopen(url).read(), "html.parser")

        for comment in soup.find_all("span", class_="txt_reply"):
            comments.append(comment.get_text())

    print(comments)

    # 결과물
    # ['1번 페이지 댓글 1', '1번 페이지 댓글 2', '1번 페이지 댓글 3', '2번 페이지 댓글 1', '2번 페이지 댓글 2', '2번 페이지 댓글 3', '3번 페이지 댓글 1', '3번 페이지 댓글 2', '3번 페이지 댓글 3']


if __name__ == "__main__":
    main()
