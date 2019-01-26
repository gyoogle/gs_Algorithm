class Person:
    def __init__(self, name, phoneNumber):
        self.name = name
        self.phoneNumber = phoneNumber
    def printInfo(self):
        print("Info(Name:{0}, Phone Number:{1}".format(self.name, self.phoneNumber))

class Student(Person):
    def __init__(self, name, phoneNumber, subject, studentID):
        Person.__init__(self,name,phoneNumber) #부모 상속
        self.subject = subject
        self.studentID = studentID
    def printInfo(self):
        print("Info(Name:{0}, Phone Number:{1}".format(self.name, self.phoneNumber))
        print("Info(Subject:{0}, StudentID:{1}".format(self.subject, self.studentID))

p = Person("전우치", "010-1234-5678")
s = Student("이순신", "010-111-1234", "컴공", "99911")

print(p.printInfo())
print(s.printInfo())
print(p.__dict__)
print(s.__dict__)