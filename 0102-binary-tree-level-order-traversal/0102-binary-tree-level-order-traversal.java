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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();
        // 엣지 케이스: 루트가 null이면 빈 리스트 반환
        if (root == null) {
            return results;
        }
        /**
        현재 레벨에 저장할 리스트 생성 및 add
        현재 레벨 노드 순회 끝나면 현재레벨에 저장된 리스트를 결과 리스트에 추가
         */
         // BFS를 위한 큐(Queue) 선언
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // 큐에 루트 노드 추가
        
        while(!q.isEmpty()){
            int levelSize = q.size();
            // 2. 현재 레벨의 노드 값들을 저장할 리스트 생성
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                currentLevel.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            results.add(currentLevel);
        }
        return results;
    }
}
