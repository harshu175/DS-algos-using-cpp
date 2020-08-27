#include<iostream>
using namespace std;

int main(){
    int n;
    cin>>n;
    int arr[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>arr[i][j];
        }
    }

    for(int i=0;i<n;i++){
        int sc = 0;
        for(int j=1;j<n;j++){
            if(arr[i][j] < arr[i][sc])
                sc = j;
        }

        bool flag = true;
        for(int k=0;k<n;k++){
            if(arr[k][sc] > arr[i][sc]){
                flag = false;
                break;
            }
        }

        if(flag == true)
        {
            cout<<arr[i][sc];
            return 0;
        }
    }

    cout<<"Invalid input";

    return 0;
}
