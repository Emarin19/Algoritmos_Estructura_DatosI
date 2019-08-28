
package linkedlist.pruebas;

import java.util.ArrayList;

public class LinkedListArray {
    NodeA head;
    
    static class NodeA{
        private ArrayList<Integer> data;
        private NodeA next;
        
        public NodeA(ArrayList<Integer> data){
            this.data = data;
            this.next = next;
        }

        public ArrayList<Integer> getData() {
            return data;
        }

        public void setData(ArrayList<Integer> data) {
            this.data = data;
        }

        public NodeA getNext() {
            return next;
        }

        public void setNext(NodeA next) {
            this.next = next;
        }
        
        
    }
    
    
    public void printList(){
        NodeA node = head;
        //ArrayList<Integer> result = new ArrayList<>();
        while(node!=null){
            System.out.println(node.getData() + " ");
            node = node.getNext();
        }
        
    }

}
