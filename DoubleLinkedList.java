public class DoubleLinkedList 
{
      private Node last;
      private Node head;
      private int size;//the current size of the list
      private final int maxSize;//the maximum size of the list, default value is 10;

      public DoubleLinkedList()
      {    
            this(10);
      }
      
      public DoubleLinkedList(int maxSize)
      {
            this.maxSize=maxSize;
      }

      public void insert(Node node)
      {
            Node current=this.head;
            if(this.head==null)
            {
            	this.head=node;
            	this.head.setNext(null);
            	this.head.setPrevious(null);
            	this.last=this.head;
            }
            else
            {
	            if(this.size<this.maxSize)
	            {
	            	while(current.getNext()!=null)
		            {
		            	current=current.getNext();
		            }
		            current.setNext(node);
		            current.getNext().setNext(null);
		            current.getNext().setPrevious(current);
		            this.last=current.getNext();
		            this.size++;
	            }
	            else
	            {
	            	System.out.println("List is full.");
	            }
            }
      }    

      public void insert(int data)
      {
            Node current=this.head;
            Node newNode=new Node(data);
            
            if(this.head==null)
            {
            	this.head=newNode;
            	this.head.setNext(null);
            	this.head.setPrevious(null);
            	this.last=this.head;
            }
            else
            {
		        if(this.size<this.maxSize-1)
		        {
		        	while(current.getNext()!=null)
		            {
		            	current=current.getNext();
		            }
		            current.setNext(newNode);
		            current.getNext().setNext(null);
		            current.getNext().setPrevious(current);
		            this.last=current.getNext();
		            this.size++;
		        }
		        else
		        {
		        	System.out.println("List is full.");
		        }
            }
      }

      public int getSize()
      {
            return this.size;
      } 

      public void remove(int index)
      {
            if(index==0)//delete the head
            {
            	this.head=head.getNext();
            	head.setPrevious(null);
            }
            else
            {
	            Node current=this.head;
	            int tempIndex=0;
	            while(tempIndex<(index-1)&&current.getNext()!=null)
	            {
	            	current=current.getNext();
	            	tempIndex++;
	            }
	            current.setNext(current.getNext().getNext());
	            if(current.getNext()!=null)
	            {
	            	current.getNext().setPrevious(current);
	            }
	            else
	            {
	            	this.last=current;
	            }
            }
            this.size--;
      }

      public void printElement(boolean reverseOrder)
      {
            if(reverseOrder==false)
            {
            	Node current=this.head;
            	while(current.getNext()!=null)
                {
                	System.out.printf("%d ",current.getData());
                	current=current.getNext();
                }
            	System.out.printf("%d \n",current.getData());
            }
            else
            {
            	Node current=this.last;
            	while(current.getPrevious()!=null)
            	{
            		System.out.printf("%d ",current.getData());
            		current=current.getPrevious();
            	}
            	System.out.printf("%d \n",current.getData());
            }
      }

      public static void bubbleSort(DoubleLinkedList list)
      {            
            for(int i=list.size-1;i>=1;i--)
            {
            	Node current=list.head;
                Node nextNode=list.head.getNext();
                Node preNode=list.head.getPrevious();
                
            	for(int j=0;j<=i;j++)
            	{
	            	if(current.getData()>nextNode.getData())
	            	{
	            		if(preNode==null)
	            		{
	            			nextNode.setPrevious(null);
	            			current.setNext(nextNode.getNext());
	            			nextNode.getNext().setPrevious(current);
	            			current.setPrevious(nextNode);
	            			nextNode.setNext(current);
	            			list.head=nextNode;
	            			preNode=current.getPrevious();
	            			nextNode=current.getNext();
	            		}
	            		else
	            		{
		            		if(nextNode.getNext()==null)
		            		{
		            			nextNode.setPrevious(current.getPrevious());
		            			current.getPrevious().setNext(nextNode);
		            			current.setNext(null);
		            			current.setPrevious(nextNode);
		            			nextNode.setNext(current);
		            		}
		            		else
		            		{
		            			nextNode.setPrevious(current.getPrevious());
		            			current.getPrevious().setNext(nextNode);
		            			current.setNext(nextNode.getNext());
		            			nextNode.getNext().setPrevious(current);
		            			current.setPrevious(nextNode);
		            			nextNode.setNext(current);
		            			nextNode=current.getNext();
		            		}
	            		}
	            	}
	            	else
	            	{
		            	current=current.getNext();
		            	nextNode=current.getNext();
		            	preNode=current.getPrevious();
	            	}
	            	
	            	if(i==list.size-1&&j==i)//define the tail of the double linked list according bubble sort property
	            	{
	            		list.last=current;
	            	}
            	}
            } 
      }
}






