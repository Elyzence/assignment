package question3;

public class DList 
{
public static void main(String args[]) {
	DList test = new DList();
	test.insertFirst((Integer) 5);
	test.insertFirst((Integer) 4);
	test.insertFirst((Integer) 3);
	System.out.println("After insert 3 nodes The list is"+test.toString());
	DNode dd=(test.header).getNext();// dd is 4
	test.insertAfter(dd, (Integer) 9);
	System.out.println("After insert 9 after 4  The list is"+test.toString());
	dd=test.tailer;
	test.insertAfter(dd, (Integer) 10);
	System.out.println("After insert 10 after tailer  The list is"+test.toString());
	dd=test.header;
	test.insertAfter(dd, (Integer) 11);
	System.out.println("After insert 11 after header  The list is"+test.toString());
	dd=test.tailer.getPrev();
	test.remove(dd);
	System.out.println("remove the second last, The list is"+test.toString());
	dd=test.tailer;
	test.remove(dd);
	System.out.println("REmove the last The list is "+test.toString());
	dd=test.header;
	test.remove(dd);
	System.out.println("REmove the header The list is "+test.toString());
	System.out.println(test.min(dd).toString());
}
  protected int numElts;             // Number of elements in the list
  protected DNode header, tailer; // Special sentinels
  /** Constructor that creates an empty list; O(1) time */
  public DList() {
    numElts = 0;
    header = null; // create header
    tailer = null; // create tailer
    //header.setNext(tailer); // make header and tailer point to each other
  }
  /** Returns the number of elements in the list;  O(1) time */
  public int size() { return numElts; }
  /** Returns whether the list is empty;  O(1) time  */
  public boolean isEmpty() { return (numElts == 0); }
  /** Returns the first position in the list; O(1) time */
  
  
  /** Insert the given element after the given position, returning the
    * new position; O(1) time  */
  public DNode insertAfter(DNode p, Object element)  {
    numElts++;
    DNode newNode = new DNode(p, element, p.getNext());
    
    if (p.getNext()!=null) {p.getNext().setPrev(newNode);}
            else {tailer =newNode;}
    p.setNext(newNode);
            numElts++;
    return newNode;
  }
  /** Insert the given element at the beginning of the list, returning
    * the new position; O(1) time  */
  public DNode insertFirst(Object element) {
    numElts++;
    DNode newNode = new DNode(null, element, header);
    
            if (header == null) {
                header=newNode; 
                tailer=newNode;
               
            }
    else {header.setPrev(newNode); header=newNode;}
            numElts++;
    return newNode;
  }
  /** Insert the given element at the end of the list, returning
    * the new position; O(1) time  */
  
  /**Remove the given position from the list; O(1) time */
  public Object remove(DNode p) {
    if (numElts==0)  {System.out.println("empty list"); return null;}
    if (p==null) {System.out.println("THe node is empty"); return null;}
    
    numElts--;
    DNode pPrev = p.getPrev();
    DNode pNext = p.getNext();
    
    Object pElem = p.getElement();
    if(pPrev != null) {pPrev.setNext(pNext);}
    else { header=pNext; }
    
    if (pNext != null) pNext.setPrev(pPrev);
    else tailer=p.getPrev();
    
    // unlink the position from the list and make it invalid
    p.setNext(null);
    p.setPrev(null);
    return pElem;
  }
  
  
  /** Returns a textual representation of the list */
  public String toString() {
    String s = "[";
    if (numElts==0) {s="[]"; return s;}
    DNode p = header;
    
    while (p !=null) {
     s += p.getElement();
    
            if (p.getNext()!=null) {
         s += ", ";
            }
     p = p.getNext();
    
    }
    s += "]";
    return s;
  }
  
  public Integer min(DNode h) {
	  if (h==null) return Integer.MAX_VALUE;
	  int x=(int) h.getElement();
	  int y=(int) min(h.getNext());
	  if(x<y) return x;
	  return y;
  }
}
