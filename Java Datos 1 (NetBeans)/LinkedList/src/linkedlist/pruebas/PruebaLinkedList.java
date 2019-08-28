
package linkedlist.pruebas;
import java.util.ArrayList;
import linkedlist.pruebas.LinkedList.Node;
import linkedlist.pruebas.LinkedListArray.NodeA;


public class PruebaLinkedList {
    
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        
        list.head.setNext(second);
        second.setNext(third);
        
        list.printList();
        
        LinkedListArray listA = new LinkedListArray();
        ArrayList<Integer> dataA = new ArrayList<>();
        dataA.add(1);
        dataA.add(1);
        listA.head = new NodeA(dataA);
        ArrayList<Integer> dataB = new ArrayList<>();
        dataB.add(1);
        dataB.add(0);
        NodeA secondA = new NodeA(dataB);
        
        ArrayList<Integer> dataC  = new ArrayList<>();
        dataC.add(0);
        dataC.add(0);
        NodeA thirdA = new NodeA(dataC);
        
        listA.head.setNext(secondA);
        secondA.setNext(thirdA);
        listA.printList();
        
    }
    
}
