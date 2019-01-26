import matplotlib.pyplot as plt
import json
from operator import itemgetter

from elice_utils import EliceUtils
from movies import titles


def preprocess_data(filename):
    '''
    입력 받은 JSON 형식의 데이터를 딕셔너리로 변환하여 리턴합니다. 이때 int()를 이용해 key를 정수로 설정합니다.
    
    >>> preprocess_data('netflix.json')
    {30: [2621442, 1048579, ...], ..., 17627: [2621442, 1048579, ...]}
    '''
    
    processed = {}
    with open(filename) as file:
        # 입력 받은 JSON 파일을 불러와 loaded에 저장합니다.
        loaded = file.read()
        data = json.loads(loaded)
        # JSON 형식의 데이터에서 영화와 사용자 정보를 하나씩 가져옵니다.
        for movie, users in data.items():
            # processed 딕셔너리에 title을 키로, user를 값으로 저장합니다.
            processed[int(movie)] = users
                
        return processed


def reformat_data(title_to_users):
    '''
    (작품 별 시청한 사용자) 딕셔너리를 (사용자 별 시청 작품) 딕셔너리로 변환합니다.
    
    >>> reformat_data(title_to_users('netflix.json'))
    {2621442: [30, 17627, ...], ...}
    '''
    
    user_to_titles = {}
    # 입력받은 딕셔너리에서 영화와 사용자 정보를 하나씩 가져옵니다.
    for movie, users in title_to_users.items():
        for user in users:
            if user in user_to_titles:
                user_to_titles[user].append(movie)
            else:
                user_to_titles[user] = [movie]
        # user_to_titles에 사용자 정보가 있을 경우 사용자의 영화 정보를 추가합니다. 이때 영화 정보는 리스트형으로 저장됩니다.
                
    
    return user_to_titles


def get_closeness(title_to_users, title1, title2):
    '''
    두 작품의 유사도를 구합니다. 이때 유사도는 (두 작품을 모두 본 사용자) / (두 작품 중 하나라도 본 사용자)와 같습니다.
    
    >>> get_closeness(preprocess_data('netflix.json'), 14312, 14454)
    0.66331
    '''
    
    # title_to_users를 이용해 title1를 시청한 사용자의 집합을 저장합니다.
    title1_users = set(title_to_users[title1])
    # title_to_users를 이용해 title2를 시청한 사용자의 집합을 저장합니다.
    title2_users = set(title_to_users[title2])
    
    # 두 작품을 모두 본 사용자를 구합니다.
    both = len(title1_users & title2_users)
    # 두 작품 중 하나라도 본 사용자를 구합니다.
    either = len(title1_users | title2_users)

    return both / either


def predict_preference(title_to_users, user_to_titles, user, title):
    '''
    작품1과 사용자A가 주어졌을 때, 예상 선호도를 계산합니다.
    작품1에 대한 사용자A의 예상 선호도는 사용자A가 시청한 모든 작품과 작품1 유사도의 평균값입니다. 
    예로, 사용자A가 시청한 3개의 작품과 작품1의 유사도가 0.6, 0.4, 0.5일 때, 선호도 점수는 0.5입니다.
    '''
    
    # user_to_titles를 이용해 user가 시청한 영화를 저장합니다.
    titles = user_to_titles[user]
    # get_closeness() 함수를 이용해 유사도를 계산합니다.
    closeness = []
    for title1 in titles:
        closeness.append(get_closeness(title_to_users, title1, title))

    return sum(closeness) / len(closeness)


def main():
    filename = 'netflix.json'
    title_to_users = preprocess_data(filename)
    user_to_titles = reformat_data(title_to_users)
    
    lotr1 = 2452                # 반지의 제왕 - 반지 원정대
    lotr2 = 11521               # 반지의 제왕 - 두 개의 탑
    lotr3 = 14240               # 반지의 제왕 - 왕의 귀환
    
    killbill1 = 14454           # 킬 빌 - 1부
    killbill2 = 457             # 킬 빌 - 2부
    
    jurassic_park = 14312       # 쥬라기 공원
    shawshank = 14550           # 쇼생크 탈출
    
    print("[유사도 측정]")
    title1 = lotr1
    title2 = lotr2
    description = "{}와 {}의 작품 성향 유사도".format(titles[title1], titles[title2])
    closeness = round(get_closeness(title_to_users, title1, title2) * 100)
    print("{}: {}%".format(description, closeness))
    
    username = 'elice'
    new_utt = user_to_titles.copy()
    new_utt[username] = [lotr1, lotr2, lotr3]
    
    print("[{} 사용자를 위한 작품 추천]".format(username))
    preferences = [(title, predict_preference(title_to_users, new_utt, 'elice', title)) for title in title_to_users]
    preferences.sort(key=itemgetter(1), reverse=True)
    for p in preferences[:10]:
        print("{} ({}%)".format(titles[p[0]], round(p[1] * 100)))


if __name__ == "__main__":
    main()
