#include <stdio.h>

#define MAXN 100
#define MAXM 100

int r[MAXN][MAXM];
int dp[MAXN][MAXM];

int cal_dp(int company, int money)
{	
	int temp = 0,max=-1;
	for (int i = 0; i <= money; i++)
	{
		dp[0][i] = r[0][i];
	}

	for (int i = 1; i < company; i++)
	{
		for (int j = 1; j <= money; j++)
		{
			max = -1;
			for (int k = 0; k <= j; k++)
			{
				temp = dp[i - 1][k] + r[i][j - k];
				if (max < temp)
				{
					max = temp;
				}
			}
			dp[i][j] = max;
		}
	}

	for (int i = 0; i < company;i++)
	{
		for (int j = 0; j <= money; j++)
		{
			printf("%d ", dp[i][j]);
		}
		printf("\n");
	}
}
int main()
{
	int money, company;
	
	scanf("%d %d", &money, &company);

	for (int i = 0; i < company; i++)
	{
		r[i][0] = 0;
	}
	for (int i = 1; i <= money; i++)
	{
		for (int j = 0; j < company; j++)
		{
			scanf("%d", &r[j][i]);
		}
	}
	cal_dp(company, money);
	printf("\n");
	printf("%d\n", dp[company-1][money]);
}