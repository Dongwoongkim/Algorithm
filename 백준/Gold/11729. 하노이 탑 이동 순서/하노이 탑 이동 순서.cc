#include <iostream>
#include <math.h>
using namespace std;
int ans;

void hanoi(int n,int a,int b)
{
	int c;
	
	if(n<=1)
	{
		cout << a << " " << b << '\n';

	}
	
	else
	{
	c= 6-a-b;
	hanoi(n-1,a,c);
	cout << a << ' '<< b << '\n';
	hanoi(n-1,c,b);
	}
}
int main()
{
	int n;
	cin >> n;
	ans = pow(2,n);
	cout << --ans << endl;
	hanoi(n,1,3);
	
	return 0;
}