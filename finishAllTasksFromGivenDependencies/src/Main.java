import java.util.ArrayList;
import java.util.Vector;

public class Main {
    //to complete task first, second task need to be completed
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    //returns adjacency list from list of pairs
    static ArrayList<ArrayList<Integer>> build_graph(int totalTasks, Vector<Pair> preRequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(totalTasks);
        for (int i = 0; i < totalTasks; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(Pair pre : preRequisites) {
            graph.get(pre.second).add(pre.first);
        }
        return graph;
    }

    //DFS approach to check if cycle exists or not
    static boolean isCycleExists(int node, boolean[] order, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        if(order[node]) return true;
        if(visited[node]) return false;
        order[node] = true;
        visited[node] = true;

        for (Integer i : graph.get(node)) {
            if(isCycleExists(i, order, visited, graph)) return true;
        }
        order[node] = false;
        return false;
    }

    //function to check whether possible finish all tasks or not
    static boolean canFinish(int totalTasks, Vector<Pair> prerequisites) {
        ArrayList<ArrayList<Integer>> graph = build_graph(totalTasks, prerequisites);
        boolean[] order = new boolean[totalTasks];
        boolean[] visited = new boolean[totalTasks];
        for (int i = 0; i < totalTasks; i++)
            if(!visited[i] && isCycleExists(i, order, visited, graph))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int totalTasks = 4;
        Vector<Pair> prerequisites= new Vector<>();

        prerequisites.add(new Pair(1, 0));
        prerequisites.add(new Pair(2, 1));
        prerequisites.add(new Pair(3, 2));

        if(canFinish(totalTasks, prerequisites)) {
            System.out.println("Possible to finish all tasks");
        } else {
            System.out.println("Impossible to finish all tasks");
        }
    }
}
