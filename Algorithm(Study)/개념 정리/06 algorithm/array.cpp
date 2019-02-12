#include <iostream>
#include <cstring>
using namespace std;

int dx[8] = { 0,0,1,-1,-1,-1,1,1 };
int dy[8] = { 1,-1,0,0,1,-1,1,-1 };

void multi(int temp[][6], int copy[][6], int mul, int x, int y, int n) {

	copy[x][y] = 1;
	if (mul == 0) {
		return;
	}
	for (int k = 0; k < 8; k++) {
		int nx = x + dx[k];
		int ny = y + dy[k];
		if (nx >= 0 && nx < n&&ny >= 0 && ny < n) {
			multi(temp, copy, mul - 1, nx, ny, n);
		}
	}

}
int main() {

	int arr[][6] = {
	{ 3, 2, 1, 2, 4, 1 },
	{ 2, 1, 2, 1, 2, 1, },
	{ 3, 2, 3, 2, 1, 4 },
	{ 2, 3, 4, 3, 4, 1, },
	{ 3, 4, 3, 4, 3, 4, },
	{ 2, 3, 4, 3, 1, 4 } };
	int n = 6;
	//배열 회전
	int copy[6][6];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			copy[i][j] = arr[n - 1 - j][i];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << copy[i][j] << ' ';
		}
		cout << endl;
	}
	cout << endl;
	//배열 달팽이
	int dx[4] = { 0,1,0,-1 };
	int dy[4] = { 1,0,-1,0 };
	int direction = 0;

	int x = 0, y = -1;
	int cnt = 0;
	int val = 1;
	int move[2] = { n, n - 1 };
	int idx = 0;
	while (cnt < n*n) {
		for (int j = 0; j < move[idx]; j++) {
			x += dx[direction];
			y += dy[direction];
			arr[x][y] = val++;
			cnt++;
		}
		direction = (direction + 1) % 4;
		move[idx]--;
		idx = (idx + 1) % 2;
	}


	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << arr[i][j] << ' ';
		}
		cout << endl;
	}
	*

		//배열 확대
		int temp[][6] = {
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, },
			{ 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, },
			{ 0, 0, 0, 0, 0, 0, },
			{ 0, 0, 0, 0, 0, 1 } };


	int mul = 2;
	int n = 6;
	int copy[6][6];

	for (int i = 0; i < n; i++) {
		memset(copy[i], 0, sizeof(int)*n);
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (temp[i][j] == 1) {
				multi(temp, copy, mul, i, j, n);
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << copy[i][j] << ' ';
		}
		cout << endl;
	}
}