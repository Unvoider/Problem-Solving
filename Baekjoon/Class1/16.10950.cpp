#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t, a, b;
	cin >> t;
	for (int _ = 0; _ < t; _++) {
		cin >> a >> b;
		cout << a + b << '\n';
	}
	return 0;
}