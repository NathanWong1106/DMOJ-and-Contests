//CCC '03 S3

#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>

using namespace std;

struct Point
{
	int row;
	int col;

	Point(int row, int col)
	{
		this->row = row;
		this->col = col;
	}
};

int FloorPlan()
{
	int sqrM, rows, cols, numFloored = 0;
	cin >> sqrM >> rows >> cols;

	vector<int> rooms;
	vector<vector<char>> map(rows, vector<char>(cols));
	vector<vector<bool>> explored(rows, vector<bool>(cols, false));


	for (int row = 0; row < rows; row++)
	{
		for (int col = 0; col < cols; col++)
		{
			cin >> map[row][col];
		}
	}

	int roomID = 0;

	for (int row = 0; row < rows; row++)
	{
		for (int col = 0; col < cols; col++)
		{
			if (map[row][col] != 'I' && !explored[row][col])
			{
				queue<Point> q;
				q.push(Point(row, col));
				rooms.push_back(1);

				while (!q.empty())
				{
					Point point = q.front();
					q.pop();

					explored[point.row][point.col] = true;

					for (int vert = point.row - 1; vert <= point.row + 1; vert++)
					{
						if (vert >= 0 && vert < rows)
						{
							if (!explored[vert][point.col] && map[vert][point.col] != 'I')
							{
								q.push(Point(vert, point.col));
								explored[vert][point.col] = true;
								rooms[roomID]++;
							}
						}
					}
					for (int hor = point.col - 1; hor <= point.col + 1; hor++)
					{
						if (hor >= 0 && hor < cols)
						{
							if (!explored[point.row][hor] && map[point.row][hor] != 'I')
							{
								q.push(Point(point.row, hor));
								explored[point.row][hor] = true;
								rooms[roomID]++;
							}
						}
					}
				}
				roomID++;
			}
		}
	}

	sort(rooms.begin(), rooms.end(), [](const int a, const int b) {return a > b;});

	for (int i : rooms)
	{
		if (sqrM - i >= 0)
		{
			sqrM -= i;
			numFloored++;
		}
		else
		{
			break;
		}
	}

	if (numFloored == 1)
	{
		cout << numFloored << " room, " << sqrM << " square metre(s) left over" << endl;
	}
	else
	{
		cout << numFloored << " rooms, " << sqrM << " square metre(s) left over" << endl;
	}


	return 0;
}