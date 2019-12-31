#include <stdio.h>

char arr[] = { 'a', 'b', 'c', 'd' };
char set[4];
int r = 3;

void printArr() {
	for (int i = 0; i < r; i++)
	{
		printf("%c ", set[i]);
	}
	printf("\n");
}

void comb(int len, int k) {
	if (len == r) {
		printArr();
		return;
	}
	if (k == sizeof(arr))
		return;

	set[len] = arr[k];

	comb(len + 1, k + 1);
	comb(len, k + 1);
}

void rcomb(int len, int k) {
	if (len == r) {
		printArr();
		return;
	}
	if (k == sizeof(arr))
		return;

	set[len] = arr[k];

	rcomb(len + 1, k);
	rcomb(len, k + 1);
}

int main(int argc, char* argv[]) {

	printf("====조합====\n");
	comb(0, 0);
	printf("====중복조합====\n");
	rcomb(0, 0);
}