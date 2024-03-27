#include <bits/stdc++.h>
#define endl '\n'
#define FASTio ios_base ::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)
#include <utility>
using namespace std;
int v[130][130];
int n;
int blue,white;


bool check(int size,int y,int x)
{
	int firstcolor = v[y][x];

	for(int i=y;i<y+size;i++)
	{
		for(int j=x;j<x+size;j++)
		{
			if(firstcolor != v[i][j])
			{
				return false;

			}
		}
	}

return true;
}

pair<int, int> pair_add(pair<int, int> a, pair<int , int> b)
{
	return make_pair(a.first+b.first,a.second+b.second);
	
}

pair <int , int>  d_q(int size,int y,int x)
{	
	int firstcolor = v[y][x];
	
	pair<int,int> ret = make_pair(0,0); // white,blue
	
	if(size==1)
	{
		if(v[y][x]==1) return make_pair(0,1);
	 	if(v[y][x]==0) return make_pair(1,0);

	}

	if(check(size,y,x)==true)
	{
		if(v[y][x]==1) return make_pair(0,1);
	 	if(v[y][x]==0) return make_pair(1,0);

	}

	else{	
		ret = pair_add(ret,d_q(size/2,y,x));
		ret = pair_add(ret,d_q(size/2,y+(size/2),x));
		ret = pair_add(ret,d_q(size/2,y,x+size/2));
		ret = pair_add(ret,d_q(size/2,y+size/2,x+size/2));
	}

return ret;

}

int main()
{
	FASTio;
	cin >> n;

	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			cin >> v[i][j];

	pair <int, int> answer = d_q(n,0,0);
	cout << answer.first << endl << answer.second;
	

	return 0;
}