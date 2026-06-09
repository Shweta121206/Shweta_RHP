#include <bits/stdc++.h>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    vector<vector<int>> arr(a, vector<int>(b));
    for (int i = 0; i < a; i++) {
        for (int j = 0; j < b; j++) {
            cin >> arr[i][j];
        }
    }

    int i, j;
    cin >> i >> j;

    int sum = 0;
    int adj[8][2] = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0},
        {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
    };

    for (int lol = 0; lol < 8; lol++) {
        int r = adj[lol][0] + i;
        int c = adj[lol][1] + j;
        if (r >= 0 && r < a && c >= 0 && c < b) {
            sum += arr[r][c];
        }
    }

    cout << sum << endl;
    return 0;
}
