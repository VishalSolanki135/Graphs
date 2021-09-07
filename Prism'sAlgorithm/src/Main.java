import java.lang.reflect.Array;
import java.util.ArrayList;

class Node {
    int u, v, weight;

    public Node(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    Node() {}

    public int getU() {return u;}

    public int getV() {return v;}

    public int getWeight() {return weight;}
}

class Main {
    static int V;

    static void prismAlgo(int[] parent, int[] key, boolean[] mstSet, ArrayList<ArrayList<Node>> adj) {
        key[0] = 0;
        parent[0] = -1;
        for (int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE, minIndex = -1;
            for (int j = 0; j < V; j++) {
                if(!mstSet[j] && key[j]<min) {
                    min=key[j];
                    minIndex = j;
                }
            }
            mstSet[minIndex]=true;

            for (Node it : adj.get(minIndex)) {
                int first = it.getU();
                int weight = it.getWeight();

                if(!mstSet[first]&&weight<key[first]) {
                    parent[first]=minIndex;
                    key[first]=weight;
                }
            }
        }
    }
}
