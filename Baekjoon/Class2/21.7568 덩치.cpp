#include <iostream>
#include <vector>
using namespace std;

struct Person {
    int weight;
    int height;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<Person> people(n);

    for (int i = 0; i < n; i++)
        cin >> people[i].weight >> people[i].height;

    for (int i = 0; i < n; i++) {
        int rank = 1; // i의 등수
        for (int j = 0; j < n; j++) {
            if (people[i].weight < people[j].weight && people[i].height < people[j].height)
                rank++;
        }
        cout << rank << ' ';
    }
    return 0;
}