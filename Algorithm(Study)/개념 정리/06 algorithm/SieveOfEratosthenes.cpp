#include <iostream>
#include <cmath>
using namespace std;

bool Prime[1000001];
int main() {

	Prime[0] = true;
	Prime[1] = true;
	for (int i = 2; i < sqrt(1000001); i++) {
		for (int j = i * 2; j < 1000001; j += i) {
			if (!Prime[j]) {
				Prime[j] = true;
			}
		}
	}

	for (int i = 0; i < 1000; i++) {
		if (!Prime[i]) {
			cout << i << ' ';
		}
	}
}