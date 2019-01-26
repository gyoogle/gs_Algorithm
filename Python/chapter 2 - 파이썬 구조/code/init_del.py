class Myclass:
    def __init__(self, value):
        self.value = value
        print("Class is created! Value = ", value)
    def __del__(self):
        print("Class is deleted!")

d = Myclass(10)
del d