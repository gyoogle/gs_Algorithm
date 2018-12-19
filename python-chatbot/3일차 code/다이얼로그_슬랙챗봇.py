# -*- coding: utf-8 -*-
import json
import os
import re
import urllib.request
import requests

from bs4 import BeautifulSoup
from slackclient import SlackClient
from flask import Flask, request, jsonify, make_response, render_template

app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

slack_token = "xoxb-503818135714-507351131587-guOlBfgMmYtpptuES8AHowe3"
slack_client_id = "503818135714.507284889508"
slack_client_secret = "5629395b663813a6bc8156667fcdb94b"
slack_verification = "XghV8wu7By7jQRBIHzHlmt1b"
sc = SlackClient(slack_token)

def get_answer(text, user_key):
    data_send = {
        'query': text,
        'sessionId': user_key,
        'lang': 'ko',
    }

    data_header = {
        'Authorization': 'Bearer e0251187ee9b4193982b4e619946f690',
        'Content-Type': 'application/json; charset=utf-8'
    }

    dialogflow_url = 'https://api.dialogflow.com/v1/query?v=20150910'
    res = requests.post(dialogflow_url, data=json.dumps(data_send), headers=data_header)

    if res.status_code != requests.codes.ok:
        return '오류가 발생했습니다.'

    data_receive = res.json()
    result = {
        "speech" : data_receive['result']['fulfillment']['speech'],
        "intent" : data_receive['result']['metadata']['intentName']
    }
    return result

# 크롤링 함수 구현하기
def _crawl_naver_keywords(text):

    # 여기에 함수를 구현해봅시다.
    keywords = ["Bugs 실시간 음악 차트 Top 10\n"]
    rankings = []
    titles = []
    singers = []
    print(text)
    if text.find('music') != -1:
        sourcecode = urllib.request.urlopen('https://music.bugs.co.kr/chart').read()
        soup = BeautifulSoup(sourcecode, "html.parser")

        for bugs_text in soup.find_all("strong"):
            rankings.append(bugs_text.get_text())
        rankings = rankings[5:15]
        print(rankings)
        for bugs_text in soup.find_all("p", class_="title"):
            titles.append(bugs_text.get_text().strip('\n'))
        titles = titles[0:10]

        for bugs_text in soup.find_all("p", class_="artist"):
            singers.append(bugs_text.get_text().strip('\n'))
        singers = singers[0:10]

        for i in range(10):
            keywords.append(rankings[i] + "위 : " + titles[i] + "/" + singers[i])
            # print(rankings[i] + titles[i] + singers[i])

    # 한글 지원을 위해 앞에 unicode u를 붙혀준다.
    return u'\n'.join(keywords)


# 이벤트 핸들하는 함수
def _event_handler(event_type, slack_event):
    print(slack_event["event"])

    if event_type == "app_mention":
        channel = slack_event["event"]["channel"]
        text = slack_event["event"]["text"]

        get_data = get_answer(text, 'session')['speech']

        keywords = _crawl_naver_keywords(get_data)
        sc.api_call(
            "chat.postMessage",
            channel=channel,
            text=keywords
        )

        return make_response("App mention message has been sent", 200, )

    # ============= Event Type Not Found! ============= #
    # If the event_type does not have a handler
    message = "You have not added an event handler for the %s" % event_type
    # Return a helpful error message
    return make_response(message, 200, {"X-Slack-No-Retry": 1})


@app.route("/listening", methods=["GET", "POST"])
def webhook():
    content = request.args.get('content')
    userid = 'session'
    return get_answer(content, userid)

def hears():
    slack_event = json.loads(request.data)

    if "challenge" in slack_event:
        return make_response(slack_event["challenge"], 200, {"content_type":
                                                                 "application/json"
                                                             })

    if slack_verification != slack_event.get("token"):
        message = "Invalid Slack verification token: %s" % (slack_event["token"])
        make_response(message, 403, {"X-Slack-No-Retry": 1})

    if "event" in slack_event:
        event_type = slack_event["event"]["type"]
        return _event_handler(event_type, slack_event)

    # If our bot hears things that are not events we've subscribed to,
    # send a quirky but helpful error response
    return make_response("[NO EVENT IN SLACK REQUEST] These are not the droids\
                         you're looking for.", 404, {"X-Slack-No-Retry": 1})


@app.route("/", methods=["GET"])
def index():
    return "<h1>Server is ready.</h1>"


if __name__ == '__main__':
    app.run('0.0.0.0', port=8080)
