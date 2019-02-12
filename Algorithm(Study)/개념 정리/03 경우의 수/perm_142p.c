#include <stdio.h>

void print_arr(int arr[], int len)
{
	for (int i = 0; i < len; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
void swap(int arr[],int i, int len)
{
	int temp = arr[i];
	arr[i] = arr[len];
	arr[len] = temp;
}
void perm(int arr[], int len, int n, int k)
{
	if (len == k)
	{
		print_arr(arr, len);
		return;
	}

	for (int i = len; i < n; i++)
	{
		swap(arr, i, len);
		perm(arr, len + 1, n, k);
		swap(arr, i, len);
	}
}
int main()
{
	int arr[100], n, k;
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++)
	{
		arr[i] = i;
	}
	perm(arr, 0, n, k);
}