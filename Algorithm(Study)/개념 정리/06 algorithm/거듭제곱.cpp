#include <iostream>

using namespace std;
int power2(int base, int ex) {
	if (ex == 0) {
		return 1;
	}
	else if (ex == 1) {
		return base;
	}
	return base * power2(base, ex - 1);
}


int power(int base, int ex) {
	if (ex == 0) {
		return 1;
	}

	int n = power(base, ex / 2);
	if (ex % 2 == 0) {
		return n*n;
	}
	else {
		return n*n*base;
	}
}

int main()
{
	cout << power(2, 1);
}