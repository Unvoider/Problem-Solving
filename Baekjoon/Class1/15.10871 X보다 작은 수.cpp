#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, x, input;
	cin >> n >> x;
	for (int i = 0; i < n; i++) {
		cin >> input;
		if (input < x)
			cout << input << ' ';
	}
	return 0;
}