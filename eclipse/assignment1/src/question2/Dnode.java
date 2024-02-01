package question2;

class DNode {
    private  DNode prev;
private  Object element;
    private  DNode next;
    /** Creates a node with null references to its element and next node. */
    public  DNode() {
       this(null, null, null);
   }
    /** Creates a node with the given element and next node. */
    public  DNode(DNode p, Object e,  DNode n)  {
        prev  =  p;
     element  =  e;
         next  =  n;
   }
    // Accessor methods:
    public  Object getElement()  {
       return  element;
   }
    public  DNode getNext()  {
       return  next;
   }
    public  DNode getPrev()  {
        return  prev;
    }
    // Modifier methods:
    public void  setElement(Object newElem)  {
         element  =  newElem;
   }
    public void  setNext(DNode newNext)  {
         next  =  newNext;
   }
    
    public void  setPrev(DNode newPrev)  {
        prev  =  newPrev;
  }
}
