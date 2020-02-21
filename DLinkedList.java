public class DLinkedList{
   int count;
   DNode head;
   DNode tail;
 
 
 //initialize the list
   public static DLinkedList initialize(){
      return new DLinkedList();
   }
 //determine whether the list is empty
   public boolean isEmpty(){
      return count == 0;
   }
 //find the length of the list
   public int getCount(){
      return count;
   }
 //output the list
 
   public String toString(){
      StringBuffer sb = new StringBuffer();
      sb.append("{");
      DNode p = head;
      while( p!= null){
         sb.append(p.getItem() + " ");
         p = p.getRight();
      }
      sb.append("}");
      return sb.toString();
   }
 
   public String reversetoString(){
      StringBuffer sb = new StringBuffer();
      sb.append("{");
      DNode p = tail;
      while( p!= null){
         sb.append(p.getItem() + " ");
         p = p.getLeft();
      }
      sb.append("}");
      return sb.toString();
   }
 
 //search the list for a given item
   public boolean search(int item){
      DNode p = head;
      while(p!=null){
         if(p.getItem()==item)
            return true;
         p = p.getRight();
      }
      return false;
   }

 //retrieve the firt element of the list
   public int getLastElement(){
      if(tail!=null)
         return tail.getItem();
      return 0;
   }

  //insert an item in the list
   //addFront
   public void addFront(int item){
      if(isEmpty())
         head = tail = new DNode(item);
      else
      {
         DNode temp = new DNode(item,null, head);
         head.setLeft(temp);
         head = temp;
      }
      count++;
   }
   
   //addLast
   public void addLast(int item) {
      if(isEmpty()) 
         tail = head = new DNode(item);
      else {
         DNode temp = new DNode(item,tail,null);
         tail.setRight(temp);
         tail = temp;
      } 
      count++; 
   }
   public void insertItemAt(int pos, int item){
      if(pos >= 0 && pos <= count){
         if(pos == 0)
            addFront(item);
         else if(pos == count)
            addFront(item);
         else{
            DNode p = head;
            int c = 0;
            while(c < pos-1){
               p = p.getRight();
               c++;
            }
            DNode p2 = p.getRight();
            DNode newNode = new DNode(item,p,p2);
            p.setRight(newNode);
            p2.setLeft(newNode);
            count++;
         } 
      }
      else
         System.out.println("Invalid position!'");
   }
   
   public void deleteFront(int item) {
      DNode p = head;
      if(count==1){
         if(p.getItem()==item){
            head = tail = null;
            count--;
         }
      }
      if(p.getItem()==item){
         head = p.getRight();
         head.setLeft(null);
         count--;
      }
   }
   
   public void deleteLast(int item) {
      DNode p = head;
      if(count==1){
         if(p.getItem()==item){
            head = tail = null;
            count--;
         }
      }
      if(tail.getItem()==item){
         tail = tail.getLeft();
         tail.setRight(null);
         count--;
      }
   }
    
   //delete an item from the list
   public void delete(int item){
      DNode p = head;
      if(count==1){
         if(p.getItem()==item){
            head = tail = null;
            count--;
         }
      }
      else if(p.getItem()==item){
         head = p.getRight();
         head.setLeft(null);
         count--;
      }
      else if(tail.getItem()==item){
         tail = tail.getLeft();
         tail.setRight(null);
         count--;
      }
      else{
         p = head;
         while(p!=tail){
            if(p.getItem()==item){
               DNode p2 = p.getRight();
               p = p.getLeft();
               p.setRight(p2);
               p2.setLeft(p);
               count--;
            }
            p = p.getRight();
         }
      }
   }

 //for testing
   public static void main(String [] args){
   
      DLinkedList list = initialize();
      list.addFront(6);
      list.addFront(1);
      list.addLast(2);
      list.addFront(4);
      list.addLast(8);
      list.insertItemAt(2,9);
      //list.delete(8);
      list.delete(6);
      list.deleteFront(4);
      list.deleteLast(8);
      System.out.println("List -> :" + list);
      System.out.println("Is found?: "+list.search(1));
      //4System.out.println("List <- :" + list.reversetoString());
   }
}