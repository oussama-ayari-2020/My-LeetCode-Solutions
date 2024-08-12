package Design_A_Class.Medium;

import java.util.*;

class Graph {
    Map<Integer, Set<Integer>> adjMap;

    public Graph() {
        adjMap=new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        /*if(!adjMap.containsKey(dst)){
            adjMap.put(dst,new HashSet<>());
        }*/
        adjMap.computeIfAbsent(dst,k-> new HashSet<>()); //Better implementation

        if(adjMap.containsKey(src)){
            Set<Integer> set=adjMap.get(src);
            set.add(dst);
        }else {
            Set<Integer> set=new HashSet<>();
            set.add(dst);
            adjMap.put(src,set);
        }
    }

    public boolean removeEdge(int src, int dst) {
        Set<Integer> set=adjMap.getOrDefault(src,new HashSet<>());
        return set.remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(src);
        visited.add(src);
        while(!queue.isEmpty()){
            int n= queue.size();
            for(int i=0;i<n;i++) {
                int cur = queue.poll();
                ArrayList<Integer> neighbours = new ArrayList<>(adjMap.getOrDefault(cur, new HashSet<>()));
                if (cur == dst)
                    return true;
                for (int neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }
        return false;
    }
}
