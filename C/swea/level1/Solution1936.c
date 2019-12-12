#include <stdio.h>

int main(void)
{
	int num1, num2;
	scanf("%d %d", &num1, &num2);
	char answer;

	if (num1 == 1) {
		if (num2 == 2)
			answer = 'B';
		else
			answer = 'A';
	}
	else if (num1 == 2) {
		if (num2 == 3)
			answer = 'B';
		else
			answer = 'A';
	}
	else {
		if (num2 == 1)
			answer = 'B';
		else
			answer = 'A';
	}

	printf("%c", answer);

	return 0;
}