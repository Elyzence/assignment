package question3;

public class NodeQueue {
protected int numElts=0;             // Number of elements in the list
  protected DNode header, tailer; // Special sentinels
  /** Constructor that creates an empty list; O(1) time */
  public NodeQueue() {
    numElts = 0;
    header = null; // create header
    tailer = null; // create tailer
    //header.setNext(tailer); // make header and tailer point to each other
  }
  
  public int size() { return numElts; }
  /** Returns whether the list is empty;  O(1) time  */
  public boolean isEmpty() { return (numElts == 0); }
  /** Returns the first position in the list; O(1) time */
  
  public Object front() {
  if (isEmpty()) {
  System.out.println("The Queue is empty"); 
      return null;
  }
  return tailer.getElement();
  }
  
  
  public DNode enqueue(Object element) {
    numElts++;
    DNode newNode = new DNode(null, element, header);
    
            if (header == null) {
                header=newNode; 
                tailer=newNode;
               
            }
    else {header.setPrev(newNode); header=newNode;}
            
    return newNode;
  }
  public DNode dequeue() {// remove the last item
  DNode temp, pre;
  temp=tailer;
  if (isEmpty())  {// the queue is empty; 
  System.out.println("The Queue is empty"); 
  return null;
  }
 
  pre=tailer.getPrev();
  if (pre !=null) {
  pre.setNext(null);  //general case, where the queue has LOTS of items
  tailer=pre;    
  
  }
  else { // the queue has one item and will be empty after dequeue()
  tailer=null;
  header=null;   
  }
  numElts=numElts-1;//
  return temp;
  
  }
  public static void main(String args[]) {
	  NodeQueue q= new NodeQueue();
	  q.enqueue((Integer) 1);
	  q.enqueue((Integer) 2);
	  q.enqueue((Integer) 3);
	  System.out.println("the first item is "+ q.front());
	  
	  System.out.println("the removed item is  "+ 
	(q.dequeue()).getElement());
	  System.out.println("the removed item is "+ 
	(q.dequeue()).getElement());
	  System.out.println("the removed item is "+ 
	(q.dequeue()).getElement());
	  System.out.println("the removed item is "+ (q.dequeue()));
  }
}
