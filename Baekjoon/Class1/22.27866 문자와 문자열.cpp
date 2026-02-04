#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	string s;
	int i;
	cin >> s >> i;
	cout << s[i - 1];
	return 0;
}