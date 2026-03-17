#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	int r, g, b;
	cin >> r >> g >> b;

	for (int _ = 1; _ < n; _++) {
		int prev_r = r, prev_g = g, prev_b = b;

		cin >> r >> g >> b;
		r += min(prev_g, prev_b); // 다른 색 중 최솟값 더하기
		g += min(prev_r, prev_b);
		b += min(prev_r, prev_g);
	}

	cout << min(min(r, g), b);
	return 0;
}

/* 확장 가능
#include <iostream>
#include <algorithm>
using namespace std;
constexpr int COLOR_TYPES = 3;
constexpr int MAX_COST = 10000000;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	int colors[COLOR_TYPES];
	for (int i = 0; i < COLOR_TYPES; i++)
		cin >> colors[i];

	for (int _ = 1; _ < n; _++) {
		int prev_colors[COLOR_TYPES];
		for (int i = 0; i < COLOR_TYPES; i++) {
			prev_colors[i] = colors[i];
			cin >> colors[i];
		}

		for (int i = 0; i < COLOR_TYPES; i++) { // 다른 색 중 최솟값 더하기
			int prev_min_cost = MAX_COST;
			for (int j = 0; j < COLOR_TYPES; j++)
				if (i != j)
					prev_min_cost = min(prev_min_cost, prev_colors[j]);
			colors[i] += prev_min_cost;
		}
	}

	int total_min_cost = colors[0];
	for (int i = 1; i < COLOR_TYPES; i++)
		total_min_cost = min(total_min_cost, colors[i]);
	cout << total_min_cost;
	return 0;
}
*/