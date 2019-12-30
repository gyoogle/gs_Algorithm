#include <stdio.h>

#define MAX_N 100

int front;
int rear;
int queue[MAX_N];

// ť init
void queueInit(void) {
	front = 0;
	rear = 0;
}

// ť ����ֳ� Ȯ��
int queueIsEmpty(void) {
	return (front == rear);
}

// ť ��á�� Ȯ��
int queueIsFull(void) {
	if ((rear + 1) % MAX_N == front) return 1;
	else return 0;
}

int queueEnqueue(int value) {
	if (queueIsFull()) {
		return 0;
	}

	queue[rear++] = value;

	if (rear == MAX_N) {// rear�� �ִ밪�̸� 0����
		rear = 0;
	}

	return 1;
}

int queueDequeue(int *value) {
	if (queueIsEmpty()) {
		return 0;
	}

	*value = queue[front];
	front++;
	if (front == MAX_N) // front�� �ִ밪�̸� 0����
		front = 0;

	return 1;
}

int main(int argc, char* argv[]) {

	int T, N;

	scanf("%d", &T);

	for (int test_case = 1; test_case <= T; test_case++)
	{
		scanf("%d", &N);

		queueInit();

		for (int i = 0; i < N; i++)
		{
			int value;
			scanf("%d", &value);
			queueEnqueue(value);
			printf("%d Enqueue!!\n", value);
		}

		printf("#%d ", test_case);

		while (!queueIsEmpty()) {
			int value;
			if (queueDequeue(&value) == 1) {
				printf("%d Dequeue!! ", value);
			}
		}
		printf("\n");
	}

	return 0;

}