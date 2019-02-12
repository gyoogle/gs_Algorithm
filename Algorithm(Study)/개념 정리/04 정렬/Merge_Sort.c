#include <stdio.h>
#include <stdlib.h>

void MergeTwoArea(int arr[], int left, int mid, int right)
{
	int fIdx = left;
	int rIdx = mid + 1;

	int *sortArr = (int *)malloc(sizeof(int)*(right + 1));
	int sIdx = left;

	while (fIdx <= mid && rIdx <= right)
	{
		if (arr[fIdx] <= arr[rIdx])
		{
			sortArr[sIdx] = arr[fIdx++];
		}
		else
		{
			sortArr[sIdx] = arr[rIdx++];
		}
		sIdx++;
	}
	if (fIdx > mid)
	{
		for (int i = rIdx; i <= right; i++, sIdx++)
		{
			sortArr[sIdx] = arr[i];
		}
	}
	else
	{
		for (int i = fIdx; i <= mid; i++, sIdx++)
		{
			sortArr[sIdx] = arr[i];
		}
	}
	for (int i = left; i <= right; i++)
	{
		arr[i] = sortArr[i];
	}
	free(sortArr);
}
void MergeSort(int arr[], int left, int right)
{
	int mid;
	if (left < right)
	{
		mid = (left + right)/2;

		MergeSort(arr, left, mid);
		MergeSort(arr, mid + 1, right);

		MergeTwoArea(arr, left, mid, right);
	}
}
int main()
{
	int arr[7] = { 3,2,4,1,7,6,5 };
	printf("%d\n", sizeof(arr) / sizeof(int) - 1);
	MergeSort(arr, 0, sizeof(arr) / sizeof(int) - 1);
	for (int i = 0; i < 7; i++)
	{
		printf("%d ", arr[i]);
	}
}