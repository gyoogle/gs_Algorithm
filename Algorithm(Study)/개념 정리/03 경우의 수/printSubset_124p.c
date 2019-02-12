#include <stdio.h>

#define MAXN 100
void printArr(int arr[],int n)
{
	for (int i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
void subset(int arr[], int set_size,int n,int index)
{
	if (n == index)
	{
		printArr(arr,set_size);
		return;
	}
	arr[set_size] = index;
	subset(arr, set_size + 1, n, index + 1);
	subset(arr, set_size, n, index + 1);
}
int main()
{
	int n,set[MAXN];
	scanf("%d", &n);
	subset(set, 0, n, 0);
}