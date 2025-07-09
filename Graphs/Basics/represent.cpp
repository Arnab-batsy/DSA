#include <iostream>
#include <vector>
using namespace std;

//Graph Representation
int main()
{
    //Storage- 1. Matrix, 2. List
    int n, m;
    cout << "Enter nodes and edges: ";
    cin >> n >> m;

    //Adjacency Matrix Time- O(n) space- O(n^2)
    int adj[n + 1][n + 1];
    cout << "Enter the edges (u v) format:" << endl;
    for (int i = 0; i < m; i++)
    {
        int u, v;
        cin >> u >> v;
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    //Adjacency List (Array of vectors) : Stores the neighbours in lists space- O(2n)
    vector<int> adjm[n+1];
    cout << "Enter the edges in (u v) format:" << endl;
    for (int i = 0; i < m; i++)
    {
        int u, v;
        cin >> u >> v;
        adjm[u].push_back(v);
        adjm[v].push_back(u);
    }
    //For directed graphs
    //adjm[u].push_back(v) ONLY
    //Space- O(edge)

    //For weighted graphs write the weight in place of 1 in the adjacency matrix
    //In case of lists. store pairs (node, weight) in each vector
    cout << "The no. of nodes is: " << n << endl;
    return 0;
}
