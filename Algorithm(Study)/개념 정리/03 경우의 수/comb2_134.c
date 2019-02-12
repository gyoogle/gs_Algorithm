#include <stdio.h>

void bit(int bits[], int n, int k, int index)
{
	if (k == 0)
	{
		for (int i = index; i < n; i++)
		{
			bits[i] = 0;
		}
			for (int j = 0; j < n; j++)
			{
				printf("%d ", bits[j]);
			}
			printf("\n");
			return;
	}
	else if (index == n)
	{
		return;
	}
	else {
		bits[index] = 0;
		bit(bits, n, k, index + 1);
		bits[index] = 1;
		bit(bits, n, k - 1, index + 1);
	}
}
void comb2(int set[],int size, int n, int k, int index)
{
	if (k == 0)
	{
		int temp[100] = { 0, };
		for (int i = 0; i < size; i++)
		{
			temp[set[i]] = 1;
		}
		for (int i = 0; i < n; i++)
		{
			printf("%d ", temp[i]);
		}
		printf("\n");
		return;
	}
	else if (n == index)
	{
		return;
	}
	set[size] = index;
	comb2(set, size + 1, n, k - 1, index + 1);
	comb2(set, size, n, k, index + 1);
}
int main()
{
	int n, k;
	int set[100];
	scanf("%d %d", &n, &k);
	//comb2(set, 0, n, k, 0);
	bit(set, n, k, 0);
}