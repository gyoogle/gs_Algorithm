#include <iostream>

using namespace std;

int memo[1000][1000];
int go(int n, int r) {
	if (memo[n][r]) {
		return memo[n][r];
	}

	if (r == 0 || n == r) {
		return memo[n][r] = 1;
	}
	return memo[n][r] = go(n - 1, r - 1) + go(n - 1, r);
}
int main() {
	int N, K;
	scanf("%d %d", &N, &K);

	//cout << go(N, K);

	for (int i = 0; i <= N; i++) {
		for (int j = 0; j <= i; j++) {
			if (j == 0 || i == j) {
				memo[i][j] = 1;
			}
			else {
				memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			cout << memo[i][j] << ' ';
		}
		cout << endl;
	}
	cout << memo[N][K];

}