# 트럼프 대통령의 트윗 모음을 불러옵니다.
from tweets import trump_tweets

# 그래프에 필요한 라이브러리를 불러옵니다. 
import matplotlib.pyplot as plt

# 단어구름에 필요한 라이브러리를 불러옵니다. 
import numpy as np
from PIL import Image
from wordcloud import WordCloud

# 특화된 컨테이너 모듈에서 수 세기를 돕는 메소드를 불러옵니다.
from collections import Counter

# 문자열 모듈에서 특수문자를 처리를 돕는 메소드를 불러옵니다. 
from string import punctuation

# 엘리스에서 이미지 출력에 필요한 패키지를 불러옵니다. 
from elice_utils import EliceUtils
elice_utils = EliceUtils()


def preprocess_text(text):
    ''' 
    문자열에서 특수문자를 삭제하고 공백을 기준으로 나누어 생성된 리스트를 반환합니다. 
    
    >>> preprocess_text('안녕 #엘리스 @토끼~!')
    ['안녕', '#엘리스', '@토끼']
    '''
    
    # 분석을 위해 text를 모두 소문자로 변환합니다.
    text = text.lower()
    
    # @와 #을 제외한 특수문자로 이루어진 문자열 symbols를 만듭니다.
    symbols = punctuation.replace('@', '').replace('#', '')
    
    # symbols 변수를 이용해 text에서 @와 #을 제외한 모든 특수문자를 제거합니다. 
    for symbol in symbols:
        text = text.replace(symbol, '')
    
    # text를 공백을 기준으로 구분합니다.
    words = text.split()
    
    return words


def analyze_text(words):
    '''
    문자열 원소의 첫 문자를 확인하고 해시태그, 멘션, 키워드로 분류합니다.
    
    >>> analyze_text(['안녕', '#엘리스', '토끼'])
    ['안녕', '엘리스', '토끼'], ['엘리스'], ['토끼']
    '''
    
    # 키워드, 해시태그, 멘션을 저장할 리스트를 각각 생성합니다.
    keywords, hashtags, mentions = [], [], []
    
    # 리스트에 저장된 단어를 분류합니다.
    for word in words:
        # 해시태그일 경우 # 기호를 제외한 단어를 해시태그와 키워드 리스트에 추가합니다. 
        if word[0] == '#':
            hashtags.append(word[1:])
            keywords.append(word[1:])
        
        # 멘션일 경우 @ 기호를 제외한 단어를 멘션과 키워드 리스트에 추가합니다.
        elif word[0] == '@':
            mentions.append(word[1:])
            keywords.append(word[1:])
        
        # 해시태그와 멘션이 아닐 경우 단어를 키워드 리스트에 추가합니다. 
        else:
            keywords.append(word)
        
    return keywords, hashtags, mentions


def filter_by_month(tweet_data, month):
    '''
    트윗 데이터와 월을 입력 받아 해당 월에 게시된 트윗을 리스트에 추가합니다. 
    
    >>> filter_by_month(trump_tweets, 1)
    ['On my way! ...', ... , '... in 2018!']
    '''
    
    # month를 문자열로 변환합니다. 한 자리 숫자에는 앞에 '0'을 입력합니다. (1 -> '01')
    month_string = '0' + str(month) if month < 10 else str(month)
    
    # 입력된 월에 해당하는 트윗을 저장할 리스트를 생성합니다. 
    monthly_tweets = []
    
    # tweet_data에서 게시일과 트윗을 가져옵니다. 
    for date, tweet in tweet_data:
        # 트윗의 날짜가 선택한 달에 속해 있으면 트윗의 내용을 monthly_tweets에 추가합니다.
        if date.startswith(month_string):
            monthly_tweets.append(tweet)
        
    
    return monthly_tweets


# 트윗 통계를 출력합니다.
def show_stats():
    '''
    가장 많이 사용한 해시태그, 멘션, 키워드를 출력합니다.
    '''
    
    keyword_counter = Counter()
    hashtag_counter = Counter()
    mention_counter = Counter()
    
    for _, tweet in trump_tweets:
        keyword, hashtag, mention = analyze_text(preprocess_text(tweet))
        keyword_counter += Counter(keyword)
        hashtag_counter += Counter(hashtag)
        mention_counter += Counter(mention)
    
    # 가장 많이 등장한 키워드, 해시태그, 멘션을 출력합니다.
    top_ten = hashtag_counter.most_common(10)
    for hashtag, freq in top_ten:
        print('{}: {}회'.format(hashtag, freq))


def show_tweets_by_month():
    '''
    앞서 작성한 함수를 이용해 월별 트윗 개수를 보여주는 그래프를 출력합니다. 
    '''

    months = range(1, 13)
    num_tweets = [len(filter_by_month(trump_tweets, month)) for month in months]
    
    plt.bar(months, num_tweets, align='center')
    plt.xticks(months, months)
    
    plt.savefig('graph.png')
    elice_utils = EliceUtils()
    elice_utils.send_image('graph.png')


def create_word_cloud():
    '''
    wordcloud 패키지를 이용해 트럼프 대통령 실루엣 모양의 단어구름을 생성합니다.
    '''
    
    counter = Counter()
    for _, tweet in trump_tweets:
        keywords, _, _ = analyze_text(preprocess_text(tweet))
        counter += Counter(keywords)
    
    trump_mask = np.array(Image.open('trump.png'))
    cloud = WordCloud(background_color='white', mask=trump_mask)
    cloud.fit_words(counter)
    cloud.to_file('cloud.png')
    elice_utils.send_image('cloud.png')


# 입력값에 따라 출력할 결과를 선택합니다. 
def main(code=1):
    '''
    입력값에 따라 출력할 결과를 선택합니다. 
    '''

    # 가장 많이 등장한 키워드, 해시태그, 멘션을 출력합니다.
    if code == 1:
        show_stats()
    
    # 트럼프 대통령의 월별 트윗 개수 그래프를 출력합니다.
    if code == 2:
        show_tweets_by_month()
    
    # 트럼프 대통령의 트윗 키워드로 단어구름을 그립니다.
    if code == 3:
        create_word_cloud()


# main 함수를 실행합니다. 
if __name__ == '__main__':
    main(3)
