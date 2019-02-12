#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <ctime>
using namespace std;
int arr[10];

void printArr(int n) {
	for (int i = 0; i < n; i++) {
		cout << arr[i] << ' ';
	}
	cout << endl;
}

void quick(int pivot, int left, int right) {
	int leftIdx = left;
	int rightIdx = right;
	cout << "pivot : " << pivot << " left : " << left << " right : " << right << endl;
	while (leftIdx < rightIdx) {
		while (arr[leftIdx] < arr[pivot] && leftIdx <= right) {
			leftIdx++;
		}
		while (arr[rightIdx] > arr[pivot] && left <= rightIdx) {
			rightIdx--;
		}

		if (rightIdx < leftIdx) {
			swap(arr[pivot], arr[rightIdx]);
			quick(pivot, pivot + 1, rightIdx);
			quick(rightIdx + 1, rightIdx + 2, right);
		}
		else {
			swap(arr[leftIdx], arr[rightIdx]);
		}
	}
}

void quick_s(int pivot, int left_idx, int right_idx)
{
	int left = left_idx;
	int right = right_idx;
	//cout << "pivot : " << pivot << " left : " << left << " right : " << right << endl;
	while (left <= right)
	{
		while (arr[pivot] >= arr[left] && left <= right_idx)
		{
			left++;
		}
		while (arr[pivot] <= arr[right] && right >= left_idx)
		{
			right--;
		}
		if (right < left)
		{
			swap(arr[pivot], arr[right]);
			quick_s(pivot, pivot + 1, right - 1);
			quick_s(right + 1, right + 2, right_idx);
		}
		else
		{
			swap(arr[left], arr[right]);
		}
	}
}
int main() {
	srand((unsigned int)time(NULL));

	for (int t = 0; t < 10; t++) {
		cout << "#" << t << "===============" << endl;
		for (int i = 0; i < 10; i++) {
			arr[i] = rand() % 100;
		}
		int n = 10;
		printArr(n);
		quick_s(0, 1, n - 1);
		printArr(n);
	}

}