package Easy.Same_Tree_100;

import Custom_Data_Structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null) return q==null;
        if(q==null) return false;
        Queue<TreeNode> bfs=new LinkedList<>();
        bfs.offer(p);
        Queue<TreeNode> bfs2=new LinkedList<>();
        bfs2.offer(q);
        while(!bfs.isEmpty() && !bfs2.isEmpty()){
            int n=bfs.size();
            for(int i=0;i<n;i++){
                TreeNode cur=bfs.poll();
                TreeNode cur2=bfs2.poll();
                if(cur.right==null && cur2.right!=null || cur2.right==null && cur.right!=null)
                    return false;
                if(cur.left==null && cur2.left!=null || cur2.left==null && cur.left!=null)
                    return false;
                if(cur.right!=null && cur.right.val!=cur2.right.val)
                    return false;
                if(cur.left!=null && cur.left.val!=cur2.left.val)
                    return false;
                if(cur.val!=cur2.val)
                    return false;
                if(cur.right!=null){
                    bfs.add(cur.right);
                    bfs2.add(cur2.right);
                }
                if(cur.left!=null){
                    bfs.add(cur.left);
                    bfs2.add(cur2.left);
                }
            }

        }
        return true;
    }
}