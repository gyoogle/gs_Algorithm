#include <stdio.h>
int BSearch(int arr[], int len, int target)
{
	int left = 0;
	int right = len - 1;
	

	while (left <= right)
	{
		int mid = (left + right) / 2;
		if (arr[mid] == target)
		{
			return mid;
		}
		else
		{
			if (arr[mid] < target)
			{
				left = mid + 1;
			}
			else
			{
				right = mid - 1;
			}
		}
	}
	return -1;
}
int main()
{
	int arr[] = { 1,3,5,7,9 };
	int idx;

	idx = BSearch(arr, sizeof(arr) / sizeof(int), 7);
	if (idx == -1)
	{
		printf("Å½»ö½ÇÆÐ\n");
	}
	else
	{
		printf("Å¸°Ù ÀúÀå ÀÎµ¦½º : %d\n", idx);
	}


}