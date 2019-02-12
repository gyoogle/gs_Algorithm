#include <stdio.h>

#define MAX(X,Y) ((X)>(Y)?(X):(Y))
#define MAXN 100

int arr[MAXN];
int dp[MAXN];
int max_2(int arr[], int n)
{
	if (n == 1)
	{
		return arr[0];
	}
	return MAX(max_2(arr, n - 1) + arr[n - 1], arr[n - 1]);
}
int max_1(int arr[], int n)
{
	if (n == 1)
	{
		return arr[0];
	}
	return MAX(max_1(arr,n-1),max_2(arr,n));
}

void max1_dp(int arr[], int n)
{
	dp[0] = arr[0];
	for (int i = 1; i < n; i++)
	{
		dp[i] = MAX(dp[i - 1] + arr[i], arr[i]);
		
	}
}
int max2_dp(int arr[], int n)
{
	
	if (n == 1)
	{
		return arr[0];
	}
	return MAX(dp[n-1],max2_dp(arr,n-1));
}
int main() {
	int num = 0;
	scanf("%d", &num);
	for (int i = 0; i < num; i++)
	{
		scanf("%d", &arr[i]);
	}
	//printf("%d\n", max_1(arr, num));
	max1_dp(arr, num);
	printf("%d\n", max2_dp(arr, num));
	printf("\n");
	for (int i = 0; i < num; i++)
	{
		printf("%d ",dp[i]);
	}
}