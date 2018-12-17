from elice_utils import EliceUtils

elice_utils = EliceUtils()
import re


def main():
    sentence = "제보는 032-232-3245 또는 010-222-2233 으로 연락주시기 바랍니다."

    compile_text = re.compile(r"\d\d\d-\d\d\d-\d\d\d\d")
    match_text = compile_text.findall(sentence)
    print(match_text)

    email = ["aa2@naver.com", "kbc@aaaaa", "Alice@Alice.com", "ILove@CodingLove"]

    compile_text = re.compile(r"^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$")

    for i in email:
        print(compile_text.match(i) != None)


if __name__ == "__main__":
    main()
