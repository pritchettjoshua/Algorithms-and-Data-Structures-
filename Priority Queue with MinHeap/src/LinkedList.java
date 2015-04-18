 
class iLinkedList {
    
    private Node startingNode;
    private int listCount;
 
  
    public iLinkedList() {
       
        startingNode = new Node(null);
        listCount = 0;
    }
 
    public void add(Object x)
    
    {
        Node iTemp = new Node(x);
        Node Current = startingNode;
        
        while (Current.getNext() != null) {
            Current = Current.getNext();
        }
      
        Current.setNext(iTemp);
        listCount++;
    }
 
    public void add(Object x, int index)
  
    {
        Node iTemp = new Node(x);
        Node Current = startingNode;
       
        for (int i = 1; i < index && Current.getNext() != null; i++) {
            Current = Current.getNext();
        }
       
        iTemp.setNext(Current.getNext());
        
        Current.setNext(iTemp);
        listCount++;
    }
 
    public Object get(int index)
    {
       
        if (index <= 0)
            return null;
 
        Node Current = startingNode.getNext();
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return null;
 
            Current = Current.getNext();
        }
        return Current.getData();
    }
    public boolean isEmpty()
    {
    	if(listCount==0)
    		return true;
    	else return false;
    }
 
    public boolean remove(int index)
    {
       
        if (index < 1 || index > size())
            return false;
 
        Node Current = startingNode;
        for (int i = 1; i < index; i++) {
            if (Current.getNext() == null)
                return false;
 
            Current = Current.getNext();
        }
        Current.setNext(Current.getNext().getNext());
        listCount--; 
        return true;
    }
    public boolean remove()
    {
    	  Node Current = startingNode;
    	  for (int i = 1; i < listCount ; i++) {
              if (Current.getNext() == null)
                  return false;
   
              Current = Current.getNext();
          }
          Current.setNext(Current.getNext().getNext());
          listCount--;  
        return true;
    }
    public int contains(Object val){
    	 Node Current = startingNode;
    	 int position = 0;
    	 int notFound =-1;
    	 while(Current.getData()!= val && Current.getNext()!=null){
    		 Current= Current.getNext();
    		 position ++; 
    	 }
   	 if (position==listCount && Current.getData()!=val)
   		 return notFound;
   	 else return position;
    }
    public int size()
 
    {
        return listCount;
    }
 
    public String toString() {
        Node Current = startingNode.getNext();
        String output = "";
        while (Current != null) {
            output += "[" + Current.getData().toString() + "]";
            Current = Current.getNext();
        }
        return output;
    }
 
    private class Node {
     
        Node next;
        
        Object x;
 
        public Node(Object xValue) {
            next = null;
            x = xValue;
        }
 
    
        public Node(Object xValue, Node nextValue) {
            next = nextValue;
            x = xValue;
        }
 
      
        public Object getData() {
            return x;
        }
 
        public void setData(Object xValue) {
            x = xValue;
        }
 
        public Node getNext() {
            return next;
        }
 
        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}