public class Node 
{
      private Node previous;
      private Node next;
      private int data;
     
      public Node(int data)
      {
            this.data = data;
      }

      public void setPrevious(Node previous)

      {
            this.previous=previous;
      }

      public void setNext(Node next)
      {
            this.next=next;
      }

      public Node getNext()
      {
            return this.next;
      }

      public Node getPrevious()
      {
            return this.previous;
      }

      public int getData()
      {
            return this.data;
      }
}