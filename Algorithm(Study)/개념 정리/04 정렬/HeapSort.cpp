#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <cstring>
using namespace std;
int arr[10] = { 0,6,3,5,7,10,1,2 };

void printArr(int n) {
	for (int i = 0; i < n; i++) {
		cout << arr[i] << ' ';
	}
	cout << endl;
}

void findLocation(int curIdx, int lastIdx) {
	int leftIdx = curIdx * 2;
	int rightIdx = leftIdx + 1;

	int minIdx = curIdx;
	if (leftIdx <= lastIdx && arr[leftIdx] < arr[minIdx]) {
		minIdx = leftIdx;
	}
	if (rightIdx <= lastIdx && arr[rightIdx] < arr[minIdx]) {
		minIdx = rightIdx;
	}

	if (minIdx != curIdx) {
		swap(arr[minIdx], arr[curIdx]);
		findLocation(minIdx, lastIdx);
	}
}
void heapify(int lastIdx) {
	int cur_idx = lastIdx / 2;

	while (cur_idx >= 1) {
		findLocation(cur_idx, lastIdx);
		cur_idx--;
	}
}

int removeRoot(int lastIdx) {
	int val = arr[1];
	arr[1] = arr[lastIdx];
	findLocation(1, lastIdx - 1);

	return val;
}
void addToHeap(int n, int lastIdx) {
	int curIdx = lastIdx + 1;
	arr[curIdx] = n;
	int parentIdx = curIdx / 2;

	while (parentIdx >= 1) {
		if (arr[parentIdx] <= arr[curIdx]) {
			break;
		}
		else {
			swap(arr[parentIdx], arr[curIdx]);
			curIdx = parentIdx;
			parentIdx = parentIdx / 2;
		}
	}

}
void heapSort(int n) {
	int sz = n - 1;
	heapify(sz);
	int *sorted = new int[sz];

	for (int i = 0; i < n - 1; i++) {
		sorted[i] = removeRoot(sz--);
	}

	for (int i = 0; i < n - 1; i++) {
		cout << sorted[i] << ' ';
	}
	cout << endl;
}
int main() {
	/*
	srand((unsigned int)time(NULL));
	for (int t = 0; t < 10; t++) {
	cout << "#" << t << "===============" << endl;
	arr[0] = 0;
	for (int i = 1; i < 10; i++) {
	arr[i] = rand() % 100;
	}
	int n = 10;
	printArr(n);

	heapSort(n);


	//printArr(n);
	}*/
	printArr(8);
	heapify(7);
	printArr(8);
	addToHeap(4, 7);
	printArr(9);
	addToHeap(4, 8);
	printArr(10);
	addToHeap(4, 9);
	printArr(11);

}