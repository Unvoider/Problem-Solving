#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

struct Person {
    int age;
    string name;
};

bool asc_age(Person p1, Person p2) {
    return p1.age < p2.age;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<Person> people(n);
    for (int i = 0; i < n; i++)
        cin >> people[i].age >> people[i].name;

    stable_sort(people.begin(), people.end(), asc_age);
    for (Person person : people)
        cout << person.age << ' ' << person.name << '\n';
    return 0;
}