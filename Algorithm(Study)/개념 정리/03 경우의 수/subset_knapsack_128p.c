#include <stdio.h>
#define MAXN 100

int value[MAXN];
int weight[MAXN];
int capacity;
int max_set[MAXN];
int max_set_size;
int max_value;
int max_size;
void evaluate_knapsack(int set[] ,int size)
{
	int cur_weight = 0, cur_value = 0;
	for (int i = 0; i < size; i++)
	{
		cur_weight += weight[set[i]];
		cur_value += value[set[i]];
	}
	if (capacity < cur_weight) return;
	if (max_value < cur_value)
	{
		max_value = cur_value;
		max_size = size;
		for (int i = 0; i < size; i++)
		{
			max_set[i] = set[i];
		}
	}
}
void subset_knapsack(int set[], int size, int n, int index)
{
	if (index == n)
	{
		evaluate_knapsack(set, size); return;
	}
	set[size] = index;
	subset_knapsack(set,size+1,n,index+1);
	subset_knapsack(set,size,n,index+1);
}
void print_arr(int arr[], int size)
{
	for (int i = 0; i < size; i++)
	{
		printf("%d ", arr[i]);
	}
}
int main()
{
	int set[MAXN], n;
	scanf("%d %d", &n, &capacity);

	for (int i = 0; i < n; i++)
	{
		scanf("%d", &value[i]);
	}
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &weight[i]);
	}

	subset_knapsack(set,0,n,0);
	printf("%d\n", max_value);
	print_arr(max_set, max_size);
}