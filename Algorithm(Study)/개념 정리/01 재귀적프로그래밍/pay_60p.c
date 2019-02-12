#include <stdio.h>

#define MAXN 50

//int main()
//{
//	int bills[6] = { 1,2,5,10,20,50 };
//	int count = 0, money = 100, i0, i1, i2, i3, i4;
//
//	for (i0 = money; i0 >= 0; i0 -= bills[0])
//	{
//		for (i1 = i0; i1 >= 0; i1 -= bills[1])
//		{
//			for (i2 = i1; i2 >= 0; i2 -= bills[2])
//			{
//				for (i3 = i2; i3 >= 0; i3 -= bills[3])
//				{
//					for (i4 = i3; i4 >= 0; i4 -= bills[4])
//					{
//						if (i4 % bills[5] == 0)
//						{
//							count++;
//						}
//					}
//				}
//			}
//		}
//	}
//
//	printf("count : %d\n", count);
//
//}

int pay_r(int money, int bills[], int n)
{
	int cnt = 0 ,t;

	if (n == 1)
	{
		if (money % bills[0] == 0)
		{
			return 1;
		}
		else {
			return 0;
		}
	}
		t = money / bills[n-1];

		for (int i = 0; i <= t; i++)
		{
			cnt += pay_r(money - bills[n - 1] * i, bills, n - 1);
		}
		printf("[money] : %d	[n] : %d	[cnt] : %d\n",money,n, cnt);
		return cnt;
		
	
}
int main()
{
	int num_bills, money;
	int bills[MAXN];

	printf("input Number of bills : ");
	scanf("%d", &num_bills);
	printf("input bills : ");
	for (int i = 0; i < num_bills; i++)
	{
		scanf("%d", &bills[i]);
	}
	printf("input money : ");
	scanf("%d", &money);
	printf("[count] : %d\n", pay_r(money, bills, num_bills));
}

//--------------------------------------------------------
#include <iostream>
#include <vector>

using namespace std;

vector<int> bills;
int cnt = 0;
void pay(int money, int n)
{
	if (money == 0)
	{
		cnt++;
		return;
	}
	else if (n == 0)
	{
		return;
	}
	int change = money / bills[n - 1];
	for (int i = change; i >= 0; i--)
	{
		int _money = money;
		_money = _money - (bills[n - 1] * i);
		pay(_money, n - 1);
	}

}
int main()
{
	int num;
	cin >> num;
	for (int i = 0; i < num; i++)
	{
		int temp;
		cin >> temp;
		bills.push_back(temp);
	}
	int money;
	cin >> money;
	pay(money, num);
	cout << cnt;
}