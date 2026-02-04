#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int input, max = -1, max_index = -1;
	for (int i = 1; i <= 9; i++) {
		cin >> input;
		if (input > max) {
			max = input;
			max_index = i;
		}
	}
	cout << max << '\n';
	cout << max_index << '\n';
	return 0;
}