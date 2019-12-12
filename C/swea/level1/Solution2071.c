#include <stdio.h>
#include <math.h>

int main(void)
{
	int tc;
	scanf("%d", &tc);


	for (int i = 1; i <= tc; ++i)
	{
		int arr[10];
		double sum = 0.0;

		for (int j = 0; j < 10; ++j)
		{
			scanf("%d", &arr[j]);
			sum += arr[j];
		}
		
		printf("#%d %d\n", i, (int)round(sum/10));
	}

	return 0;
}