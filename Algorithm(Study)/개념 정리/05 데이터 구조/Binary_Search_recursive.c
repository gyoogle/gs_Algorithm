#include <stdio.h>
int BSearch(int arr[], int left,int right, int target)
{
	
	int mid = (left + right) / 2;
	if (left > right)
	{
		return -1;
	}
	if (arr[mid] == target)
	{
		return mid;
	}
	else
	{
		if (arr[mid] < target)
		{
			return BSearch(arr, mid + 1, right, target);
		}
		else
		{
			return BSearch(arr, left, mid - 1, target);
		}
	}


}
int main()
{
	int arr[] = { 1,3,5,7,9 };
	int idx;

	idx = BSearch(arr, 0,sizeof(arr)/sizeof(int)-1, 7);
	if (idx == -1)
	{
		printf("Å½»ö½ÇÆĞ\n");
	}
	else
	{
		printf("Å¸°Ù ÀúÀå ÀÎµ¦½º : %d\n", idx);
	}


}