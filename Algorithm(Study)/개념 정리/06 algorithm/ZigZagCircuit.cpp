#include <iostream>

using namespace std;

int main() {
	int arr[6][6] = { { 3, 2, 1, 2, 4, 1 },
	{ 2, 1, 2, 1, 2, 1, },
	{ 3, 2, 3, 2, 1, 4 },
	{ 2, 3, 4, 3, 4, 1, },
	{ 3, 4, 3, 4, 3, 4, },
	{ 2, 3, 4, 3, 1, 4 } };

	int n = 6;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << arr[i][(i % 2) ? n - j - 1 : j] << ' ';

		}
		cout << endl;
	}
	cout << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << arr[i][j + (i % 2)*(n - 1 - 2 * j)] << ' ';

		}
		cout << endl;
	}
}