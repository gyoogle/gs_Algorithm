#include <stdio.h>

int factorial(int n)
{
	int r = 1;
	for (int i = 2; i <= n; i++)
	{
		r *= i;
	}

	return r;
}

int factorial2(int n)
{
	if (n == 0)
	{
		return 1;
	}
	else
	{
		return n*factorial2(n - 1);
	}
}
int main()
{
	printf("%d %d", factorial(0), factorial2(0));
}