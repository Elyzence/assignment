package question3;

public class BinaryTree {
protected BNode root;
protected int size;
/**Creates an empty binary tree. */
public BinaryTree(){
root=null;
size=0;
}
/**Returns the number of nodes in the tree. */
public int size(){
return size;
}
/**Returns whether the tree has any nodes or not. */
public boolean isEmpty(){
return (size==0);
}
/**Returns the root of the tree. */
public BNode root(){
return root;
}
/**Returns the parent of a given node. */
public BNode parent(BNode p){
return p.getParent();
}
/**Returns the left child of a given node. */
public BNode leftChild(BNode p){
return p.getLeftChild();
}
/**Returns the right child of a given node. */
public BNode rightChild(BNode p){
return p.getRightChild();
}
/**Returns the object stored in a given node. */
public Object element(BNode p){
return p.getElement();
}
/**Returns whether a node has a left child. */
public boolean hasLeft(BNode p){
return p.getLeftChild()!=null;
}
}