#include <stdio.h>

int front;
int tail;
int size = 5;
int arr[5];
int isEmpty()
{
	return (front == (tail)) ? 1 : 0;
}
int isFull()
{
	return (front == (tail + 1) % size) ? 1 : 0;
}
void printArr()
{
	for (int i = 0; i < size; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}
void enqueue(int v)
{
	if (isFull())
	{
		printf("FULL\n");
		return;
	}
	tail = (tail + 1) % size;
	arr[tail] = v;

	printArr();
}
int dequeue()
{
	if (isEmpty())
	{
		printf("Empty\n");
		return 0;
	}
	front = (front + 1) % size;
	int temp = arr[front];
	return temp;
}
int main()
{
	enqueue(1);
	enqueue(20);
	enqueue(30);
	enqueue(40);
	enqueue(50);
	enqueue(60);
	printf("%d\n", dequeue());
	printf("%d\n", dequeue());
	printf("%d\n", dequeue());
	printf("%d\n", dequeue());
	printf("%d\n", dequeue());
	printf("%d\n", dequeue());
}