#include <iostream>
#include <string>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	string str;
	int count = 1;
	getline(cin, str); // 공백 포함 문자열
	for (int i = 0; i < str.length(); i++)
		if (str[i] == ' ') count++;
	if (str[0] == ' ') count--; // 첫 문자 공백
	if (str[str.length() - 1] == ' ') count--; // 끝 문자 공백
	cout << count;
	return 0;
}