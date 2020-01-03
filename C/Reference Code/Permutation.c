#include <stdio.h>

char arr[4] = { 'a', 'b', 'c', 'd' };
char set[4];
int visit[4];
int r = 2;

void printfArr() {
	for (int i = 0; i < sizeof(set); i++)
	{
		printf("%c ", set[i]);
	}
	printf("\n");
}

// 순열
void perm(int len) {

	if (len == r) {
		printfArr();
		return;
	}

	for (int i = 0; i < sizeof(arr); i++)
	{
		if (visit[i] == 0) {
			set[len] = arr[i];
			visit[i] = 1;
			perm(len + 1);
			visit[i] = 0;
		}
	}

}

void rperm(int len) {

	if (len == r) {
		printfArr();
		return;
	}

	for (int i = 0; i < sizeof(arr); i++)
	{
		set[len] = arr[i];
		rperm(len + 1);
	}

}

int main() {

	printf("====순열====\n");
	perm(0);
	printf("====중복순열====\n");
	rperm(0);
}