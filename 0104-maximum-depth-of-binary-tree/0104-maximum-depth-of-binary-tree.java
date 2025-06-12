/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // 엣지 케이스: 루트가 null이면 빈 리스트 반환
        if (root == null) {
            return 0;
        }

        /**
        현재 레벨 노드 갯수 만큼 돌면서 left right 체크
        left right 있으면 해당 노드 큐에 추가
         */

        // BFS를 위한 큐(Queue) 선언
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // 큐에 루트 노드 추가

        int depth = 0;

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i = 0; i< levelSize; i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }

            depth++;
        }

        return depth;

    }
}