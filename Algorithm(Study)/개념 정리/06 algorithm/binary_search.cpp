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

void binary_s(int left, int right, int find)
{
	if (left > right) {
		cout << "no" << endl;
		return;
	}
	int mid = (left + right) / 2;
	if (arr[mid] == find) {
		cout << "find" << ' ' << find << endl;
		return;
	}
	else if (arr[mid] > find) {
		binary_s(left, mid - 1, find);
	}
	else {
		binary_s(mid + 1, right, find);
	}
}
int main() {
	int n = 10;
	sort(arr, arr + n);

	int find = 0;
	int left = 0;
	int right = n - 1;
	//binary_search는 배열안에 값이 있는지 없는지만 판단
	cout << binary_search(arr, arr + n, 100) << endl;
	cout << binary_search(arr, arr + n, 99) << endl;
	cout << binary_search(arr, arr + n, 97) << endl;
	for (int i = 0; i <= 100; i++) {
		binary_s(left, right, i);
	}

	/*
	while (left<=right) {
	int mid = (left + right) / 2;
	if (find == arr[mid]) {
	cout << "find" << endl;
	break;
	}
	if (find > arr[mid]) {
	left = mid + 1;
	}
	else {
	right = mid - 1;
	}
	}
	cout << "end" << endl;
	*/
}