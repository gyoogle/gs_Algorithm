#include <stdio.h>

void printArr(int arr[], int n)
{
	for (int i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
void rperm(int arr[], int len, int n, int k)
{
	if (len == k)
	{
		printArr(arr, len);
		return;
	}
	for (int i = 0; i < n; i++)
	{
		arr[len] = i;
		rperm(arr, len + 1, n, k);
	}
}
int main()
{
	int arr[100], n, k;
	scanf("%d %d", &n, &k);
	rperm(arr, 0, n, k);
	
}