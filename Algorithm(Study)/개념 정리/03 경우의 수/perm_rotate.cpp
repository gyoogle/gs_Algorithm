void r_rotate(int arr[], int s, int t)
{
    int temp = arr[t];
    for (int i = t; i > s; i --)
    {
        arr[i] = arr[i - 1];
    }
    arr[s] = temp;
}
void l_rotate(int arr[], int s, int t)
{
    int temp = arr[s];
    for (int i = s; i < t; i ++)
    {
        arr[i] = arr[i + 1];
    }
    arr[t] = temp;
}
void permutation(int *now, int idx, int n, int k)
{
    if (idx == k)
    {
        for (int i = 0; i < k; i ++)
        {
            cout << now[i] << " ";
        }
        cout << endl;
        return;
    }
 
    for (int i = idx; i < n; i ++)
    {
        r_rotate(now, idx, i);
        permutation(now, idx + 1, n, k);
        l_rotate(now, idx, i);
    }
}