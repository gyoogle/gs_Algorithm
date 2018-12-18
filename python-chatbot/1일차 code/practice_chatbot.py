from elice_utils import EliceUtils
import urllib.request
from bs4 import BeautifulSoup
from urllib import parse

elice_utils = EliceUtils()


def main():
    
    # URL 데이터를 가져올 사이트 url 입력
    search = input()
    
    encode = parse.quote(search)
    
    listNews = []
    image = []
    
    for i in range(0,3):
        url = "https://search.naver.com/search.naver?&where=news&query=" + encode + "&sm=tab_pge&sort=1&photo=0&field=0&reporter_article=&pd=0&ds=&de=&docid=&nso=so:dd,p:all,a:all&mynews=0&start=" + str((i*10)+1) +"&refresh_start=0"
        soup = urllib.request.urlopen(url).read()
        #print(soup)
        # URL 주소에 있는 HTML 코드를 soup에 저장합니다.
        temp = BeautifulSoup(soup, "html.parser")
        news = temp.find_all("a", class_=" _sp_each_title")
        images = temp.find_all("image")
        
        for naver_text in news:
            listNews.append(naver_text.get_text())
            
        for image in news:
            listNews.append(image)

    print(listNews)


if __name__ == "__main__":
    main()
