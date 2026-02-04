#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int h, m;
	cin >> h >> m;
	if ((m -= 45) < 0) {
		m += 60;
		if ((h -= 1) < 0)
			h += 24;
	}
	cout << h << ' ' << m;
	return 0;
}