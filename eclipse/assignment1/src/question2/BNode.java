package question2;

class BNode{
private Object element;
private BNode parent,leftChild,rightChild;
public BNode(){
this(null,null,null,null);
}
/** Creates a node with the given element, parent,left child and right
child. */
public BNode(Object ele, BNode p, BNode left, BNode right){
parent=p;
element=ele;
leftChild=left;
rightChild=right;
}
/**Accessor methods: */
public Object getElement(){
return element;
}
public BNode getParent(){
return parent;
}
public BNode getLeftChild(){
return leftChild;
}
public BNode getRightChild(){
return rightChild;
}
/**Modifier methods: */
public void setElement(Object ele){
element=ele;
}
public void setParent(BNode p){
parent=p;
}
public void setLeftChild(BNode left){
leftChild=left;
}
public void setRightChild(BNode right){
rightChild=right;
}
}