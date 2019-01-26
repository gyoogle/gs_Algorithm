str = "Not Class Member"
class GString:
	str = ""
	def set(self, msg):
		self.str = msg
	def print(self):
		print(self.str)

g = GString()
g.set("First Message")
g.print()