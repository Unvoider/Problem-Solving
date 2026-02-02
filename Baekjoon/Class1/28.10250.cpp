#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t, h, w, n, y, x;
	cin >> t;
	while (t--) {
		cin >> h >> w >> n;
		y = (n - 1) % h + 1;
		x = (n - 1) / h + 1;
		/* 다른 풀이
		y = n % h;
		x = n / h + 1;
		if (y == 0) { // 나머지가 0이면 꼭대기 층
			y = h;
			x -= 1;
		}
		*/
		cout << y * 100 + x << '\n';
	}
	return 0;
}