#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;
vector<string> combos;

void findCombo(string word, string toAppend) {
	if (toAppend.length() == 0) {
		combos.push_back(word);
		return;
	}

	for (int i = 0, length = toAppend.length(); i < length; i++) {
		//append to word
		string wCopy = word;
		wCopy.push_back(toAppend[i]);

		//update the letters available to append
		string appendCopy = toAppend;
		appendCopy.erase(appendCopy.begin() + i);

		//recursively call function
		findCombo(wCopy, appendCopy);
	}
}

int wordScrambler() {

	string word;
	
	cin >> word;

	for (int i = 0, length = word.length(); i < length; i++) {
		string wCopy = word;
		string w = word.substr(i, 1);
		wCopy.erase(wCopy.begin() + i);

		findCombo(w, wCopy);

	}

	sort(combos.begin(), combos.end());

	for (auto w : combos) {
		cout << w << endl;
	}

	return 0;

}