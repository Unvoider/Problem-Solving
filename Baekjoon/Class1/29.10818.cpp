#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, input, min = 10000001, max = -10000001;
	cin >> n;
	while (n--) {
		cin >> input;
		if (input < min) min = input;
		if (input > max) max = input;
	}
	cout << min << ' ' << max;
	return 0;
}