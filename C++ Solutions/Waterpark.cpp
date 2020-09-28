//CCC '07 S4

#include <iostream>
#include <vector>
#include <map>
#include <queue>

using namespace std;

int Waterpark() {
	int n;
	scanf_s("%d", &n);
	vector<vector<int>> mappings(n, vector<int>(0)); // maps the slide number to all the connections going to it
	map<int, int> ways;

	int currentX = 0;
	int currentY = 0;

	do {
		scanf_s("%d %d", &currentX, &currentY);
		
		if (currentX == 0 && currentY == 0) {
			break;
		}
		else {
			mappings[currentY - 1].push_back(currentX - 1);
		}
	} while (true);

	for (int slide = 1; slide < n; slide++) {
		for (int connection : mappings[slide]) {
			ways[slide] += ways[connection];
		}
	}

	cout << ways[n - 1];

	return 0;
}