#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
#define FASTio ios_base :: sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)
#define endl '\n' 

using namespace std;
int n,m;
vector<int> arr(8,0);
vector<bool> check(8,false);

void rec(int n,int pos)
{
    if(pos==m)
    {
        for(int i=0;i<m;i++)
        {
            cout << arr[i] << ' ';
        }
        cout << endl;
        return;
    }

    else
    {
        for(int i=1;i<=n;i++)
        {   
            if(check[i]==false && i>=arr[pos-1])
            {   
                check[i]=true;
                arr[pos]=i;
                rec(n,pos+1);
                check[i]=false;
            }
        }
    }
}
int main()
{
    FASTio;
    cin >> n >> m;

    rec(n,0);


    return 0;
}