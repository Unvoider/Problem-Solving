#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool dict_sort(string& s1, string& s2) {
    if (s1.length() != s2.length()) // 길이순 정렬
        return s1.length() < s2.length();
    return s1 < s2; // 문자순 정렬
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    vector<string> words;

    cin >> n;
    for (int _ = 0; _ < n; _++) {
        string word;
        cin >> word;
        words.push_back(word);
    }
    sort(words.begin(), words.end(), dict_sort); // 정렬
    words.erase(unique(words.begin(), words.end()), words.end()); // 중복 삭제
    for (string word : words)
        cout << word << '\n';
    return 0;
}