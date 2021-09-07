import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Language {
    private static int V;
    private static ArrayList<ArrayList<Integer>> adj;

    Language(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    //add Edge
    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }


    //topological sort
    static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> iterator = adj.get(v).listIterator();
        while(iterator.hasNext()) {
            i = iterator.next();
            if(!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    static void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print((char)('a'+stack.pop()) + " ");
        }
    }

    static void printOrder(String[] words, int alphabet) {
        Language graph = new Language(alphabet);
        for (int i = 0; i < V-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j)!=word2.charAt(j)){
                    graph.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
                    break;
                }
            }
        }
        graph.topologicalSort();
    }


    public static void main(String[] args) {
        String[] words = {"caa", "aaa", "aab"};
        printOrder(words, 3);
    }
}
