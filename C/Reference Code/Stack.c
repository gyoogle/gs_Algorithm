#include <stdio.h>

#define MAX_N 100

int top;
int stack[MAX_N];

// 스택 Init
void stackInit(void) {
	top = 0;
}

// 스택 비어있나 체크
int stackIsEmpty(void) {
	return (top == 0);
}

// 스택 꽉찼나 체크
int stackIsFull(void) {
	return (top == MAX_N);
}

// push
int stackPush(int value) {
	if (stackIsFull()) return 0;
	stack[top++] = value;

	return 1;
}

// pop
int stackPop(int *value) {
	if (top == 0) return 0;

	top--;
	*value = stack[top];

	return 1;
}

int main(int argc, char* argv[]) {

	int T, N;

	scanf("%d", &T);

	for (int t = 1; t <= T; t++)
	{
		scanf("%d", &N);
		stackInit();
		for (int i = 0; i < N; i++)
		{
			int value;
			scanf("%d", &value);
			stackPush(value);
		}

		printf("#%d ", t);

		while (!stackIsEmpty()) {
			int value;
			if (stackPop(&value) == 1) {
				printf("%d ", value);
			}
		}
		printf("\n");
	}

	return 0;
}