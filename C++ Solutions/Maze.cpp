//CCC '08 S3

#include <iostream>
#include <queue>
#include <vector>
#include <string>

using namespace std;

struct Point {
	int x;
	int y;
	int parents;

	Point(int x, int y, int parents) {
		this->x = x;
		this->y = y;
		this->parents = parents;
	}
};

int Maze()
{
	vector<int> answers;
	int testCases;

	cin >> testCases;

	for (int i = 0; i < testCases; i++) 
	{
		int cols;
		int rows;
		bool exitFound = false;

		cin >> rows >> cols;

		vector<vector<char>> maze(rows, vector<char>(cols));
		vector<vector<bool>> checked(rows, vector<bool>(cols, false));
		queue<Point> q;
		q.push(Point(0, 0, 1));

		for (int row = 0; row < rows; row++) 
		{
			string rowStr = "";
			cin >> rowStr;
			for (int y = 0 ; y < rowStr.length(); y++) {
				maze[row][y] = rowStr[y];
			}
		}

		while (!q.empty())
		{
			Point point = q.front();
			q.pop();

			if (point.x == cols - 1 && point.y == rows - 1)
			{
				answers.push_back(point.parents);
				exitFound = true;
				break;
			}

			switch (maze[point.y][point.x]) {
				case '+': {
					for (int row = point.y - 1; row <= point.y + 1; row++)
					{
						if (row != point.y && row >= 0 && row < rows) {
							if (!checked[row][point.x] && maze[row][point.x] != '*')
							{

								if (point.x == cols - 1 && row == rows - 1)
								{
									answers.push_back(point.parents + 1);
									exitFound = true;
									break;
								}

								checked[row][point.x] = true;
								q.push(Point(point.x, row, point.parents + 1));
							}
						}
					}
					for (int col = point.x - 1; col <= point.x + 1; col++)
					{
						if (col != point.x && col >= 0 && col < cols) {
							if (!checked[point.y][col] && maze[point.y][col] != '*')
							{

								if (col == cols - 1 && point.y == rows - 1)
								{
									answers.push_back(point.parents + 1);
									exitFound = true;
									break;
								}

								checked[point.y][col] = true;
								q.push(Point(col, point.y, point.parents + 1));
							}
						}
					}
					break;
				}
				case '-': {
					for (int col = point.x - 1; col <= point.x + 1; col++)
					{
						if (col != point.x && col >= 0 && col < cols) {
							if (!checked[point.y][col] && maze[point.y][col] != '*')
							{

								if (col == cols - 1 && point.y == rows - 1)
								{
									answers.push_back(point.parents + 1);
									exitFound = true;
									break;
								}

								checked[point.y][col] = true;
								q.push(Point(col, point.y, point.parents + 1));
							}
						}
					}
					break;
				}
				case '|': {
					for (int row = point.y - 1; row <= point.y + 1; row++)
					{
						if (row != point.y && row >= 0 && row < rows) {
							if (!checked[row][point.x] && maze[row][point.x] != '*')
							{

								if (point.x == cols - 1 && row == rows - 1)
								{
									answers.push_back(point.parents + 1);
									exitFound = true;
									break;
								}

								checked[row][point.x] = true;
								q.push(Point(point.x, row, point.parents + 1));
							}
						}
					}
					break;
				}
				default: {
					continue;
				}
			}

			if (exitFound)
			{
				break;
			}

		}
		if (!exitFound)
		{
			answers.push_back(-1);
		}
	}

	for (int answer : answers)
	{
		cout << answer << endl;
	}

	return 0;
}