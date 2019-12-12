#include <stdio.h>

int main(void)
{
	int num;
	scanf("%d", &num);

	long long sum = 1;

	for (int i = 0; i <= num; i++)
	{
		if(i != 0)
			sum *= 2;
		printf("%lld ", sum);
	}

	return 0;
}