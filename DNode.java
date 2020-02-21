public class DNode{

  private DNode left;
  private DNode right;
  private int item;
  
  public DNode(int item, DNode left, DNode right){
   this.item = item;
   this.left = left;
   this.right = right;
  }
  
  public DNode(int item){
   this(item, null,null);
  }
  
  public DNode(){}
  
  //setters
  public  void setLeft(DNode left){
   this.left = left;
   }
  
  public void setRight(DNode right){
  
   this.right = right;
   }
   
   public void setItem(int item){
    this.item = item;
   }
   
   //getters
   public DNode getLeft(){return left;}
   public DNode getRight(){return right;}
   public int getItem(){return item;}
}