#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int arr[6];
int main()
{
	srand((unsigned int)time(NULL));
	for (int t = 0; t < 10; t++) {

		for (int i = 0; i < 6; i++) {
			arr[i] = rand() % 10;
			cout << arr[i] << ' ';
		}
		cout << endl;

		int cnt[10] = { 0, };
		for (int i = 0; i < 6; i++) {
			cnt[arr[i]]++;
		}

		int chk = 0;
		//triplet 검사
		for (int i = 0; i < 10; i++) {
			if (cnt[i] >= 3) {
				chk++;
				cnt[i] -= 3;
				i--;
			}
		}

		//run 검사
		for (int i = 0; i < 8; i++) {
			if (cnt[i] >= 1 && cnt[i + 1] >= 1 && cnt[i + 2] >= 1) {
				chk++;
				cnt[i]--;
				cnt[i + 1]--;
				cnt[i + 2]--;
				i--;
			}
		}

		if (chk == 2) {
			cout << "baby gin" << endl;
		}
		else {
			cout << "NO" << endl;
		}
	}



}