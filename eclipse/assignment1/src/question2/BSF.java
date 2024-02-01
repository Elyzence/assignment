package question2;

public class BSF {
    public static void BFS(BNode root) {
        if (root == null) {
            return;
        }
        NodeQueue queue = new NodeQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BNode node = (BNode) queue.dequeue().getElement();
            System.out.print(node.getElement() + " ");
            if (node.getLeftChild() != null) {
                queue.enqueue(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue.enqueue(node.getRightChild());
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BNode root = new BNode(1, null, null, null);
        BNode left = new BNode(2, null, null, null);
        BNode right = new BNode(3, null, null, null);
        BNode leftleft = new BNode(4, null, null, null);
        BNode leftright = new BNode(5, null, null, null);
        BNode rightleft = new BNode(6, null, null, null);
        BNode rightright = new BNode(7, null, null, null);
        root.setLeftChild(left);
        root.setRightChild(right);
        left.setLeftChild(leftleft);
        left.setRightChild(leftright);
        right.setLeftChild(rightleft);
        right.setRightChild(rightright);
        tree.root = root;
        BFS(tree.root);
    }
}
