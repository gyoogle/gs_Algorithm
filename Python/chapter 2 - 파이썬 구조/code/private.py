class BankAccount:
    __id = 0
    _name = ""
    __balance = 0

    def __init__(self, id, name, balance):
        self.__id = id
        self._name = name
        self.__balance = balance
    def deposit(self, amount):
        self.__balance += amount
    def withdraw(self, amount):
        self.__balance -= amount
    def __str__(self):
        return "{0}, {1}, {2}".format(self.__id, self._name, self.__balance)

account1 = BankAccount(100, "전우치", 15000)
account1.withdraw(3000)
print(account1)

#print(account1._BankAccount__id)
print(account1._name)
print(account1._BankAccount__balance)