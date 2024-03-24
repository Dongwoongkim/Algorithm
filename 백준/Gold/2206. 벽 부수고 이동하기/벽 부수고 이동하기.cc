#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
#include <queue>
#define FASTio ios_base :: sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)
#define endl '\n' 
using namespace std;

vector<vector<char>> v(1001,vector<char>(1001));
bool check[1001][1001][2];
int n,m,k;
int dy[]={-1,1,0,0};
int dx[]={0,0,-1,1};

int bfs(int y,int x)
{
    queue<pair<pair<int,int>,pair<int,int>>> q;
    q.push(make_pair(make_pair(y,x),make_pair(0,0)));
    check[y][x][0]=true;

    while(!q.empty())
    {
        int y = q.front().first.first;
        int x = q.front().first.second;
        int cnt = q.front().second.first;
        int ans = q.front().second.second;

        if(y==n-1 && x==m-1)
        {
            return ans+1;
        }
        q.pop();

        for(int i=0;i<4;i++)
        {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny>=0 && nx>=0 && ny<n && nx<m)
            {
                if(check[ny][nx][cnt+1]==false && v[ny][nx]=='1' &&cnt<1)
                {
                    q.push(make_pair(make_pair(ny,nx),make_pair(cnt+1,ans+1)));
                    check[ny][nx][cnt+1] = true;
                }
                else if(check[ny][nx][cnt]==false && v[ny][nx]=='0')
                {   
                    q.push(make_pair(make_pair(ny,nx),make_pair(cnt,ans+1)));
                    check[ny][nx][cnt]=true;
                
                }
            }
        }
    }


    return -1;
}
int main()
{
    FASTio;
    cin >> n >> m;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            cin >> v[i][j];
        }
    }
    int ans = bfs(0,0);
    cout << ans;

    return 0;
}