#include <iostream>
#include <algorithm>
using namespace std;
int arr[10] = { 3,10,100,99,62,78,1,0,34,11 };

void printArr(int n) {
	for (int i = 0; i < n; i++) {
		cout << arr[i] << ' ';
	}
	cout << endl;
}

int main() {
	int n = 10;
	for (int i = 1; i < n; i++) {
		int j = i - 1;
		int temp = arr[i];
		while (j >= 0 && temp < arr[j]) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = temp;

	}
	printArr(n);
}