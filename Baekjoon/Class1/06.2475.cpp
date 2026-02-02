#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int input, total = 0;
	for (int i = 0; i < 5; i++) {
		cin >> input;
		total += input * input;
	}
	cout << total % 10;
	return 0;
}