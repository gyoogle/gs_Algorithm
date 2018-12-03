class Person:
    name = "Default Name"
    def print(self):
        print("My name is {0}".format(self.name))

p1 = Person()
p1.name = "Joe"
p1.print()