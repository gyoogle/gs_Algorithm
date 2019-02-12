#include <stdio.h>

#define MAXN 100
void rcomb(int set[], int size, int n, int k, int index)
{
	if (k == 0)
	{
		for (int i = 0; i < size; i++)
		{
			printf("%d ", set[i]);
		}
		printf("\n");
		return;
	}
	else if (n == index)
	{
		return;
	}
	set[size] = index;
	rcomb(set, size + 1, n, k - 1, index );
	rcomb(set, size, n, k, index + 1);
}
int main()
{
	int n, k;
	int set[MAXN];
	scanf("%d %d", &n, &k);
	rcomb(set, 0, n, k, 0);
}