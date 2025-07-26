package top8;

public class LinkedListUsingDummy {
    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node removeElements(Node head, int val){

        Node dummy = new Node(-1);
        dummy.next = head;
        Node current = head;
        Node previous = dummy;

        while(current != null){

            if(current.val == val){
                previous.next = current.next;
            }else{
                previous = current;
            }
            current =  current.next;
        }
        return 	dummy.next;
    }
}
