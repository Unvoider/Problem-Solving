#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    stack<int> num_stack;
    string out = "";
    int n;
    cin >> n;

    num_stack.push(0); // top 접근을 위한 더미 데이터
    int num_to_push = 1;
    for (int _ = 0; _ < n; _++) { // n번 pop
        int num_to_pop;
        cin >> num_to_pop;
        while (num_stack.top() < num_to_pop) { // pop할 숫자가 없으면
            num_stack.push(num_to_push++); // push하기
            out.append("+\n");
        }
        if (num_stack.top() > num_to_pop) { // top이 pop할 숫자 초과(실패)
            out = "NO";
            break;
        }
        num_stack.pop(); // pop할 숫자 찾음
        out.append("-\n");
    }
    cout << out;
    return 0;
}