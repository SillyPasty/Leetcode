#include <iostream>
#include <math.h>
using namespace std;

int get_odd(int a, int b)
{
    int x = (a + 1) / 2;
    x -= b / 2;
    return x;
}

int get_even(int a, int b)
{
    int x = a / 2 + 1;
    x -= (b - 1) / 2;
    if (b != 0)
        x--;
    return x;
}

int get_len(long x)
{
    int len = 0;
    while (x)
    {
        len++;
        x /= 10;
    }
    return len;
}

bool is_boring(long x)
{
    int len = get_len(x);
    while (len)
    {
        if (len % 2 != x % 2)
            return false;
        x /= 10;
        len--;
    }
    return true;
}
// long get_boring(long upper, long lower, int len)
// {
//     long result = 1;
//     if (upper < lower)
//         return 0;
//     while (len > 0)
//     {
//         int bit_a = upper % 10;
//         int bit_b = lower % 10;
//         upper /= 10;
//         lower /= 10;
//         if (len % 2)
//         {
//             result *= get_odd(bit_a, bit_b);
//         }
//         else
//         {
//             result *= get_even(bit_a, bit_b);
//         }
//         len--;
//     }
//     return result;
// }

int main()
{
    int T;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        long result = 0;
        long L, R;
        cin >> L >> R;
        for (long i = L; i <= R; i++)
            if (is_boring(i))
                result++;
        // int l_len = get_len(L);
        // int r_len = get_len(R);
        // for (int i = l_len; i <= r_len; i++)
        // {
        //     if (i == l_len && i == r_len)
        //     {
        //         if (R / 10 != L / 10)
        //         {
        //             long upper_cell = (L / 10 + 1) * 10;
        //             result += get_boring(upper_cell - 1, L, i);
        //             cout << result << endl;
        //             long downer_cell = (R / 10) * 10;
        //             result += get_boring(R, downer_cell, i);
        //             cout << result << endl;
        //             result += get_boring(downer_cell-1, upper_cell, i);
        //             cout << result << endl;
        //         }
        //         else
        //             result += get_boring(R, L, i);
        //     }
        //     else if (i == l_len)
        //     {
        //         long upper_cell = (L / 10 + 1) * 10;
                
        //         result += get_boring(upper_cell - 1, L, i);
        //         result += get_boring((long)pow(10, i) - 1, upper_cell, i);
        //     }
        //     else if (i == r_len)
        //     {
        //         long downer_cell = (R / 10) * 10;
        //         result += get_boring(R, downer_cell, i);
        //         result += get_boring(downer_cell - 1, (long)pow(10, i), i);
        //     }
        //     else
        //     {
        //         cout << (long)pow(10, i) - 1 << " " << (long)pow(10, i-1) << endl;
        //         result += get_boring((long)pow(10, i) - 1, (long)pow(10, i-1), i);
        //         // cout << result << endl;
        //     }
        //     cout << result << endl;
        // }
        cout << "Case #" << i + 1 << ": " << result << endl;
    }
    return 0;
}