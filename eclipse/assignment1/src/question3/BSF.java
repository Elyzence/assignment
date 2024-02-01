package question3;

public class Bsf {
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
    
    public static DList BFSn(BNode root) {
        DList result = new DList();
        if (root == null) {
            return result;
        }
        NodeQueue queue = new NodeQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BNode node = (BNode) queue.dequeue().getElement();
            result.insertLast(node.getElement());
            if (node.getLeftChild() != null) {
                queue.enqueue(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue.enqueue(node.getRightChild());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BNode root = tree.initialize();
        System.out.println("Breadth-first traversal:");
        BFS(root);
        System.out.println();
        System.out.println("Breadth-first traversal (nodes):");
        DList nodes = BFSn(root);
        DNode currentNode = nodes.getFirst();
        while (currentNode != null) {
            System.out.print(currentNode.getElement() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }
}
