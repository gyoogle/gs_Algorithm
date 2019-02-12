#include <stdio.h>

void printArr(int arr[], int size)
{
	for (int i = 0; i < size; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
void swap(int arr[], int s, int t)
{
	int temp = arr[t];
	arr[t] = arr[s];
	arr[s] = temp;
}
void selection(int arr[], int size)
{
	for (int i = 0; i < size; i++)
	{
		int min = i;
		for (int j = i+1; j < size; j++)
		{
			if (arr[min] > arr[j])
			{
				min = j;
			}
		}
		swap(arr, min, i);
		printArr(arr, size);
	}
}
int main()
{
	int data[10] = { 7,5,4,9,1 };

	printf("-----------------------------------------------\n");
	printf("Before being sorted\n");
	printArr(data, 10);
	printf("-----------------------------------------------\n");

	selection(data, 5);

}