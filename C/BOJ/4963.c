/* 
	2020-01-03
	¼¶ÀÇ °³¼ö
	https://www.acmicpc.net/problem/4963
*/

#include <stdio.h>

int w, h, cnt, map[51][51], visit[51][51];
int dy[] = { -1,-1,-1,0,0,1,1,1 };
int dx[] = { -1,0,1,-1,1,-1,0,1 };

void init(int *, int size);

int check(int y, int x) {
	
	if (!map[y][x] || visit[y][x])
		return 0;

	visit[y][x] = 1;

	for (int i = 0; i < sizeof(dy); i++)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny < 0 || nx < 0 || ny >= 51 || nx >= 51)
			continue;

		if (map[ny][nx] && !visit[ny][nx]) {
			check(ny, nx);
		}
	}

	return 1;
}

int main(void) {

	while (1) {

		cnt = 0;

		init(map, sizeof(map) / 4);
		init(visit, sizeof(visit) / 4);

		scanf("%d %d", &w, &h);

		if (w == 0 && h == 0)
			return 0;

		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < w; j++)
			{
				scanf("%d", &map[i][j]);
			}
		}

		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < w; j++)
			{
				cnt += check(i, j);
			}
		}

		printf("%d\n", cnt);

	}

	return 0;

}

void init(int *arr, int size) {
	for (int i = 0; i < size; i++)
	{
		arr[i] = 0;
	}
}