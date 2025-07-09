#include <iostream>
#include <queue>
#include <vector>
using namespace std;

class abc{
public:
    static void dfs(vector<vector<int>> &adj){
        //Space- O(3n) ~ O(n)
        //Time- O(n) + O(2E)
        int vis[adj.size()+1]= {0}; //Visited array
        vis[1]=1;
        queue<int> q;
        q.push(1);
        vector<int> bfs;
        while(!q.empty())
        {
            int node = q.front();
            q.pop();
            bfs.push_back(node);

            for (auto it: adj[node])
            {
                if(!vis[it])
                {
                    vis[it]=1;
                    q.push(it);
                }
            }
        }
        for(auto ele: bfs)
        {
            cout<<ele<<" ";
        }
        cout<<endl;
    }
};

int main(){
    // Depth-First Search: Recursive traversal
    // Need a queue data structure and a visited array;
    int n,m;
    cout<<"Enter the number of nodes and edges: ";
    cin>>n>>m;

    vector<vector<int>> adj(n+1);
    cout<<"Enter the edges in (u v) format: "<<endl;
    for(int i=0;i<m;i++){
        int u,v;
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    abc ob;
    abc::dfs(adj);
    return 0;
}
