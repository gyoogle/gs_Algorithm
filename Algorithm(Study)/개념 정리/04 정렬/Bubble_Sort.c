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
void bubble(int arr[], int size)
{
	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size - 1 - i; j++)
		{
			if (arr[j] > arr[j + 1])
			{
				swap(arr,j, j+1);
			}
		}
		printArr(arr, size);
	}

	
}
int main()
{
	int data[10] = { 23,17,5,90,12 };

	printf("-----------------------------------------------\n");
	printf("Before being sorted\n");
	printArr(data, 10);
	printf("-----------------------------------------------\n");

	bubble(data, 5);

}