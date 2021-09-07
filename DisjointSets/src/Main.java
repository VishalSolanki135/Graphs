public class Main {
    int[] rank, parent;
    int n;

    Main(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    //Creates n sets in which node is their parent itself
    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    //return representative of x's set
    int findParent(int node) {
        if(parent[node]!=node) {
            parent[node] = findParent(parent[node]);//path compression
        }
        return parent[node];
    }

    //union of set that includes x and the set that includes x
    void union(int u, int v) {
        int uP = findParent(u), vP = findParent(v);

        //Element same set, no unite
        if(uP==vP) return;

        if(rank[uP] < rank[vP]) parent[uP] = vP;
        else if(rank[uP] > rank[vP]) parent[vP] = uP;
        else{
            parent[vP] = uP;
            rank[uP] = rank[uP] + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Main dus = new Main(n);
        dus.union(0, 2);
        dus.union(4, 2);
        dus.union(3, 1);

        //check if 4 is in same component that of 0
        if(dus.findParent(4) == dus.findParent(0)) System.out.println("Yes"); else System.out.println("No");
        if(dus.findParent(1) == dus.findParent(0)) System.out.println("Yes"); else System.out.println("No");

    }
}
