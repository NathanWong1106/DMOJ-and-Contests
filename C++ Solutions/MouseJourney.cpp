//CCC '12 S5

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int MouseJourney()
{
	int R, C, K;
	cin >> R >> C >> K;

	vector<vector<int>> possibilities (R, vector<int>(C, 0));
	vector<vector<bool>> cats (R, vector<bool>(C, false));
	vector<vector<bool>> checked(R, vector<bool>(C, false));

	for (int i = 0; i < K; i++)
	{
		int row, col;
		cin >> row >> col;
		cats[row - 1][col - 1] = true;
	}

	possibilities[0][0] = 1;
	queue<pair<int, int>> q;
	q.push(make_pair(0, 0));

	while (!q.empty())
	{
		pair<int, int> coord = q.front();
		q.pop();

		if (coord.first + 1 < R)
		{
			possibilities[coord.first + 1][coord.second] += possibilities[coord.first][coord.second];
			if (!cats[coord.first + 1][coord.second] && !checked[coord.first + 1][coord.second])
			{
				checked[coord.first + 1][coord.second] = true;
				q.push(make_pair(coord.first + 1, coord.second));
			}

			
		}
		if (coord.second + 1 < C)
		{
			possibilities[coord.first][coord.second + 1] += possibilities[coord.first][coord.second];
			if (!cats[coord.first][coord.second + 1] && !checked[coord.first][coord.second + 1])
			{
				checked[coord.first][coord.second + 1] = true;
				q.push(make_pair(coord.first, coord.second + 1));
			}
		}
	}

	cout << possibilities[R - 1][C - 1] << endl;
	return 0;
}