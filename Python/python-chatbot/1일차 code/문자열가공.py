from elice_utils import EliceUtils

elice_utils = EliceUtils()
import urllib.request
from bs4 import BeautifulSoup


def main():
    url = "http://www.newsis.com/eco/list/?cid=10400&scid=10404"
    req = urllib.request.Request(url)
    sourcecode = urllib.request.urlopen(url).read()
    soup = BeautifulSoup(sourcecode, "html.parser")

    for text in soup.find_all("strong", class_="title"):

        num = text.get_text().find("…") # 찾으면 1, 못 찾으면 0

        if (num != -1): # ...포함 되면
            print(text.get_text()[0:num])
        else:
            print(text.get_text())


if __name__ == "__main__":
    main()
