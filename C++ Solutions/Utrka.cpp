//COCI '14 Contest 2 #2

#include <iostream>
#include <map>
#include <string>
#include <iterator>

using namespace std;

int Utrka()
{
	map<string, int> participants;
	int num;

	cin >> num;

	for (int i = 0; i < num; i++)
	{
		string participant;
		cin >> participant;

		if (participants.count(participant) == 1)
		{
			participants[participant]++;
		}
		else
		{
			participants[participant] = 1;
		}
	}

	for (int i = 0; i < num - 1; i++)
	{
		string participant;
		cin >> participant;
		participants[participant]--;
	}

	map<string, int>::iterator itr;
	
	for (itr = participants.begin(); itr != participants.end(); itr++)
	{
		if (itr->second == 1)
		{
			cout << itr->first << endl;
			exit(0);
		}
	}

	return 0;
}