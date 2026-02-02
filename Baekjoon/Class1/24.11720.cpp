#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, total = 0;
	string num;
	cin >> n >> num;
	for (int i = 0; i < n; i++)
		total += num[i] - '0';
	cout << total;
	return 0;
}