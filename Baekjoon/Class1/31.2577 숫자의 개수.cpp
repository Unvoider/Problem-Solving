#include <iostream>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int a, b, c, product, remainder;
	int count[10] = { 0 };
	cin >> a >> b >> c;
	product = a * b * c;
	while (product != 0) {
		remainder = product % 10;
		count[remainder]++;
		product /= 10;
	}
	for (int i = 0; i < 10; i++) {
		cout << count[i] << '\n';
	}
	return 0;
}