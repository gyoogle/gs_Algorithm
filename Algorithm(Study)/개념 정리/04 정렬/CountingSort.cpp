#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <cstring>
using namespace std;
int arr[10];

void printArr(int n) {
	for (int i = 0; i < n; i++) {
		cout << arr[i] << ' ';
	}
	cout << endl;
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
		

		int cnt_sz = 0;
		for (int i = 0; i < n; i++) {
			if (cnt_sz < arr[i]) {
				cnt_sz = arr[i] + 1;
			}
		}		
		int *cnt = new int[cnt_sz];
		int *sorted = new int[n];
		memset(cnt, 0, sizeof(int)*cnt_sz);
		memset(sorted, 0, sizeof(int)*n);
	
		for (int i = 0; i < n; i++) {
			cnt[arr[i]]++;
		}

		for (int i = 1; i < cnt_sz; i++) {
			cnt[i] = cnt[i] + cnt[i - 1];
		}
		
		for (int i = n - 1; i >= 0; i--) {
			cnt[arr[i]]--;			
			sorted[cnt[arr[i]]] = arr[i];
		}

		for (int i = 0; i < n; i++) {
			arr[i] = sorted[i];
		}

		printArr(n);
	}
	
}