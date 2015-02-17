public class Main
{
      public static void main(String[] args) 
      {
            DoubleLinkedList list = new DoubleLinkedList();
            DoubleLinkedList list2 = new DoubleLinkedList(5);
            list.insert(6);
            list.insert(5);
            list.insert(3);
            Node node1 = new Node(1);
            list.insert(node1);
            list.insert(8);
            list.insert(7);
            Node node2 = new Node(2);
            list.insert(node2);
            list.insert(4);
            list.printElement(false);
            list.printElement(true);
            DoubleLinkedList.bubbleSort(list);
            list.printElement(false);
            list.remove(3);
            list.printElement(false);
            list.printElement(true);

            list2.insert(3);
            list2.insert(5);
            list2.insert(1);
            Node node3 = new Node(2);
            list2.insert(node3);
            list2.insert(4);
            list2.insert(6);
            list2.printElement(false);
            list2.printElement(true);
            DoubleLinkedList.bubbleSort(list2);
            list2.remove(4);
            list2.printElement(false);
            list2.printElement(true);
            list2.remove(0);
            list2.printElement(false);
            list2.printElement(true);
      }
}