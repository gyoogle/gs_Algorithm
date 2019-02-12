#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;

int gcd(int x, int y){
	if (y == 0) {
		return x;
	}
	int ret = x%y;

	gcd(y, ret);
}

int lcm(int x, int y) {
	return x*y / gcd(x, y);
}
int main() {
	int a, b;
	scanf("%d %d", &a, &b);

	printf("%d\n", gcd(max(a,b), min(a,b)));
	printf("%d\n", lcm(a, b));
}