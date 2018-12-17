from elice_utils import EliceUtils

elice_utils = EliceUtils()
import numpy as np
import matplotlib.pyplot as plt


def main():
    print("----산포도1----")

    x = np.arange(0, 100)
    y = np.arange(0, 100)
    print(x)
    plt.plot(x, y, "o")     #plt.plot(x, y, "k") 
    
    plt.savefig("image.svg", format="svg")
    elice_utils.send_image("image.svg")
    
    print("----산포도2----")

    line = plt.figure()

    np.random.seed(5)
    x = np.arange(1, 101)
    y = 20 + 3 * x + np.random.normal(0, 40, 100)
    plt.plot(x, y, "o")
    plt.savefig("image.svg", format="svg")
    elice_utils.send_image("image.svg")


    print("----파이차트----")

    slices_hours = [5, 3, 8]
    activities = ["Sleep", "Work", "Nothing"]

    color = ["gray", "blue", "red"]

    plt.pie(slices_hours, labels=activities, colors=color, startangle=90, autopct='%.1f%%')

    plt.savefig("image.svg", format="svg")
    elice_utils.send_image("image.svg")


if __name__ == "__main__":
    main()
