#include <stdio.h>

int main(void)
{
	int tc;
	scanf("%d", &tc);

	for (int t = 1; t <= tc; ++t)
	{
		int num1, num2;
		scanf("%d %d", &num1, &num2);
		char answer;

		if (num1 > num2)
			answer = '>';
		else if (num1 < num2)
			answer = '<';
		else
			answer = '=';
		printf("#%d %c\n", t, answer);
	}
}