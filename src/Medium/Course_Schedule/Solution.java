package Medium.Course_Schedule;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList=new HashMap<>();
        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<numCourses;i++)
            adjList.put(i,new ArrayList<>());
        for(int[] vertex : prerequisites){
            int a=vertex[0];
            int b=vertex[1];
            List<Integer> preq=adjList.get(a);
            preq.add(b);
            adjList.put(a,preq);
        }
        for (int i=0;i<numCourses;i++){
            if(!dfs(i,adjList,visited)) return false;
        }
        return true;
    }
    public boolean dfs(int cur,Map<Integer, List<Integer>> adjList,Set<Integer> visited){
        if(visited.contains(cur)) return false;
        if(adjList.get(cur).isEmpty()) return true;
        List<Integer> preq=adjList.get(cur);
        visited.add(cur);
        for(int pre : preq){
            if(!dfs(pre,adjList,visited)) return false;
        }
        visited.remove(cur);
        adjList.put(cur,new ArrayList<>());
        return true;
    }
}
