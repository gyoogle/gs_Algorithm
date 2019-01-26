class Tiger:
    def jump(self):
        print("호랑이 점프!!")
    def cry(self):
        print("호랑이 어흥~")
class Lion:
    def play(self):
        print("사자 활동 중")
    def cry(self):
        print("사자 으르렁~")
class Liger(Tiger, Lion):
    def bite(self):
        print("라이거 물기")

l = Liger()
l.bite()
l.cry() # 다중 상속(먼저 상속받은 Tiger로)