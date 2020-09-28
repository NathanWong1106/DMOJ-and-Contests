//CCC '20 J4

#include <string>
#include <iostream>
#include <vector>

using namespace std;

int cyclicShifts() {
	string findString;
	string text;
	vector<string> shifts;

	cin >> findString;
	cin >> text;

	shifts.push_back(text);

	for (int i = 0; i < (text.length() - 1); i++) {
		char front = text[0];
		text.erase(text.begin());
		text.push_back(front);
		shifts.push_back(text);
	}

	for (auto x : shifts) {
		// findString returns str::string::npos if a substring is not found
		if (findString.find(x) != string::npos) {
			cout << "yes" << endl;
			exit(0);
		}
	}

	cout << "no" << endl;
	return 0;
}