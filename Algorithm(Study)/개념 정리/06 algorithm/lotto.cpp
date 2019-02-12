#include <iostream>
#include <cstdlib>
#include <ctime>
#include <algorithm>
#include <set>
using namespace std;

int uniqueNum(int idx, int lotto[]) {
	bool flag = true;
	int num = 0;
	while (flag) {
		flag = false;
		num = rand() % 45 + 1;
		for (int i = 0; i < idx; i++) {
			if (lotto[i] == num) {
				flag = true;
				break;
			}
		}
	}
	return  num;
}


int main()
{
	srand((unsigned int)time(NULL));
	for (int t = 0; t < 10; t++) {
		cout << "#" << t << "================" << endl;
		//set 사용
		set<int> s;

		while (s.size() < 6) {
			s.insert(rand() % 45 + 1);
		}
		set<int>::iterator it = s.begin();

		for (it; it != s.end(); ++it) {
			cout << *it << ' ';
		}
		cout << endl;



		//for문 사용
		/*
		int lotto[6];

		for (int i = 0; i < 6; i++) {
		lotto[i] = uniqueNum(i, lotto);
		}

		sort(lotto, lotto + 6);
		for (int i = 0; i < 6; i++) {
		cout << lotto[i] << ' ';
		}
		cout << endl;
		*/
	}


}