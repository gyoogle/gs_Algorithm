from elice_utils import EliceUtils

elice_utils = EliceUtils()
from matplotlib import pyplot as plt


def main():
    print("비교 차트 그리기")

    plt.xlabel("person")
    plt.ylabel("grade")

    # Python
    plt.plot(['a', 'b', 'c', 'd', 'e'], [30, 60, 10, 80, 20])

    # Java
    plt.plot(['a', 'b', 'c', 'd', 'e'], [20, 90, 10, 10, 50])

    plt.savefig("image.svg", format="svg")
    elice_utils.send_image("image.svg")


if __name__ == "__main__":
    main()
