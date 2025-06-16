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
// 세 가지 정보를 하나로 묶어주는 전용 클래스
class NodeInfo {
    TreeNode node;
    Long min; // int의 범위를 넘어서는 무한대를 표현하기 위해 Long 타입을 사용하고, null로 초기값을 설정
    Long max;

    public NodeInfo(TreeNode node, Long min, Long max) {
        this.node = node;
        this.min = min;
        this.max = max;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        // 엣지 케이스: 루트가 null이면 빈 리스트 반환
        if (root == null) {
            return false;
        }
        /**
        1. left < root.val < right
         */
        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root,null,null)); // 큐에 루트 노드 추가

        while(!q.isEmpty()){
            NodeInfo info = q.poll();
            TreeNode currentNode = info.node;
            Long min = info.min;
            Long max = info.max;

            if(min != null && currentNode.val <= min){
                return false;
            }
            if(max != null && currentNode.val >= max){
                return false;
            }

            if(currentNode.left != null){
                q.add(new NodeInfo(currentNode.left,min,(long)currentNode.val));
            }
            if(currentNode.right != null){
                q.add(new NodeInfo(currentNode.right,(long)currentNode.val,max));
            }
        }

        return true;
    }
}